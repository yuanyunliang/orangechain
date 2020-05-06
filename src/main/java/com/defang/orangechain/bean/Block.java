/**   
 * Copyright © 2020 defangchain. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.defang.orangechain.bean 
 * @author: yunliang   
 * @date: 2020年4月29日 下午4:05:59 
 * @version: V1.0
 */
package com.defang.orangechain.bean;

import org.apache.commons.codec.digest.Sha2Crypt;

import com.alibaba.fastjson.JSON;

import lombok.Data;

/**   
* @Description: 区块：包含区块头和区块体
*/
@Data
public class Block {
    private Header header;
    private Body body;
    
}
