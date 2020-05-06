/**   
 * Copyright © 2020 defangchain. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.defang.orangechain.bean 
 * @author: yunliang   
 * @date: 2020年4月29日 下午4:17:42 
 * @version: V1.0
 */
package com.defang.orangechain.bean;

import lombok.Data;

/**   
* @Description: 描述
*/
@Data
public class Transaction {

	private String from;
	private String to;
	private String value;
	private String timestamp;
}
