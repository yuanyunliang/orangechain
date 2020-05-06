/**   
 * Copyright © 2020 defangchain. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.defang.orangechain.utils 
 * @author: yunliang   
 * @date: 2020年4月29日 下午4:55:31 
 * @version: V1.0
 */
package com.defang.orangechain.utils;

import com.alibaba.fastjson.JSON;
import com.defang.orangechain.MySpringBootWebApp;
import com.defang.orangechain.bean.Block;
import com.defang.orangechain.bean.Body;
import com.defang.orangechain.bean.Header;
import com.defang.orangechain.bean.Transaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Sha2Crypt;
import org.springframework.beans.factory.annotation.Value;

/**   
* @Description: 描述
*/
public class BlockUtils {
	@Value("${blockchain.version}")
	static String version;

	public static Block generateNewBlock(Transaction tx) {
		Block block = new Block();
		Block lastBlock = getLastBlock();
		Header header = new Header();
		Body body = new Body();
		ArrayList<Transaction> txs = new ArrayList<Transaction>();
		tx.setTimestamp(new SimpleDateFormat("yyyy-DD-dd HH:mm:ss").format(new Date()));
		txs.add(tx);
		body.setTxs(txs);
		
		//header.setPrv_hash(Sha2Crypt.sha256Crypt(JSON.toJSONBytes(lastBlock.getHeader())));
		header.setPrv_hash(getHash(lastBlock));
		header.setVersion(version);
		header.setDifficulty("123456");
		header.setNonce("789");
		header.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		header.setMerkleRootHash(getMerkleRootHash(body));
		
		block.setHeader(header);
		block.setBody(body);
		return block;
	}
	
	public static Block getLastBlock() {
		return MySpringBootWebApp.blocks.get(MySpringBootWebApp.blocks.size()-1);
	}
	
	public static String getMerkleRootHash(Body body) {
		//此次简化，应该实现生成merkle tree的方法，然后tx俩俩hash, 最终生成merkle root hash
		return DigestUtils.sha256Hex(JSON.toJSONBytes(body));
	}
	
	public static boolean isBlockvalid(Block newBlock, Block oldBlock) {
		boolean isNotValid = false;
		//检查新块的pre_hash和旧块的hash是否一致
		if(!getHash(oldBlock).equals(getPreHash(newBlock))) {
			isNotValid = true;
		}
		//检查当前块header中的merkle root hash与Body hash一致，保证tx没有被篡改
		if(!newBlock.getHeader().getMerkleRootHash().equals(getMerkleRootHash(newBlock.getBody()))) {
			isNotValid = true;
		}
		return isNotValid;
	}
	
	public static String getHash(Block block) {
    	return DigestUtils.sha256Hex(JSON.toJSONBytes(block.getHeader()));
    }
    
    public static String getPreHash(Block block) {
    	return block.getHeader().getPrv_hash();
    }
    
    
	
	//将区块写入到文件进行持久化，后续需要进行编码保存，而不是明文保存
	public static void writeBlockToFile(Block block) {
		System.out.println("已持久化到文件");
	}
}
