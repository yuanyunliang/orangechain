package com.defang.orangechain;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.client.TestRestTemplate;

/**
 * @Description 测试web服务
 */
public class WebServiceTest extends WebJunitTester {

	@Autowired
	private TestRestTemplate restTemplate;

	@Value("${server.port}")
	String port;

	@Test
	public void testLogin() {
		restTemplate.getForObject("http://localhost:" + port + "/showchain", String.class);
	}
}
