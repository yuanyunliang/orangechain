package com.defang.orangechain;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**   
* @Description 基于springboot后端项目的测试基类
*/
@RunWith(SpringRunner.class)
@ComponentScan({ "com.defang","test.com.defang" })
@TestPropertySource("classpath:application.yml")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class WebJunitTester {
}
