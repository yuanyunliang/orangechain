/**   
 * Copyright © 2020 defangchain. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.defang.orangechain.bean 
 * @author: yunliang   
 * @date: 2020年4月29日 下午4:05:20 
 * @version: V1.0
 */
package com.defang.orangechain.bean;

import java.util.ArrayList;

import lombok.Data;

/**   
* @Description: 区块体
*/
@Data
public class Body {

	private ArrayList<Transaction> txs;
}
