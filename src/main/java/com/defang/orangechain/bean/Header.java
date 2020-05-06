/**   
 * Copyright © 2020 defangchain. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.defang.orangechain.bean 
 * @author: yunliang   
 * @date: 2020年4月29日 下午4:03:37 
 * @version: V1.0
 */
package com.defang.orangechain.bean;

import lombok.Data;

/**   
* @Description: 区块头
*/
@Data
public class Header {

	private String prv_hash;
	private String version;
	private String timestamp;
	private String difficulty;
	private String nonce;
	private String merkleRootHash;
}
