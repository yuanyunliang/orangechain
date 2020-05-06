/**   
 * Copyright © 2020 defangchain. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.defang.orangechain.service 
 * @author: yunliang   
 * @date: 2020年5月6日 上午11:01:04 
 * @version: V1.0
 */
package com.defang.orangechain.service;

/**   
* @Description: 描述
*/
public interface RestRequestService {

	<T> T post(String url, String data, Class<T> clazz);
}
