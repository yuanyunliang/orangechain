package com.defang.orangechain.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.defang.orangechain.MySpringBootWebApp;
import com.defang.orangechain.bean.Block;
import com.defang.orangechain.bean.Transaction;
import com.defang.orangechain.utils.BlockUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**   
* @Description
* @author 张国豪
*/
/**
 * @Description
 */
@Api("操作区块")
@RestController
@RequestMapping
public class HomeController {

	@ApiOperation(value = "显示整个区块链的内容", notes = "显示整个区块链的内容---")
	@RequestMapping(value = "/showchain", method = {RequestMethod.GET, RequestMethod.POST})
	public String showChain() {
		return JSON.toJSONString(MySpringBootWebApp.blocks);
	}

	@ApiOperation(value = "增加区块", notes = "增加区块---")
	@RequestMapping(value = "/addblock", method = { RequestMethod.POST })
	//@ResponseBody
	public Object addBlock(@RequestBody Transaction tx) {
        Block newBlock = BlockUtils.generateNewBlock(tx);
        //加入新块到区块链之前，需要校验，新块中的交易是否被篡改（检查hash）,新块的prv_hash 是否与前一个区块一致，校验无误后，才将其写入区块链
        Block lastBlock = BlockUtils.getLastBlock();
        boolean isNotValid = BlockUtils.isBlockvalid(newBlock, lastBlock);
        if(isNotValid) {
        	return "false";
        }
        MySpringBootWebApp.blocks.add(newBlock);
        //TODO:后续考虑有多条连，选择最长的链作为有效的链
        BlockUtils.writeBlockToFile(newBlock);
		return "success";
	}

	
}
