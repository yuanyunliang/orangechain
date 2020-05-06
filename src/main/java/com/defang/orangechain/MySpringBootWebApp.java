package com.defang.orangechain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.defang.orangechain.bean.Block;
import com.defang.orangechain.bean.Body;
import com.defang.orangechain.bean.Header;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@EnableDubboConfiguration
@EnableTransactionManagement
@ComponentScan({ "com.defang" })
@EnableSwagger2
//@EnableScheduling
public class MySpringBootWebApp {
	@Value("${blockchain.version}")
	static String version;
	public static ArrayList<Block> blocks = new ArrayList<Block>();
	public static void main(String[] args) {
		createGenesisBlock();
		new SpringApplication(MySpringBootWebApp.class).run(args);
	}
	
	private static  void createGenesisBlock() {
		Block genesisBlock = new Block();
		Header header = createGenesisHeader();
		Body body = createGenesisBody();
		genesisBlock.setHeader(header);
		genesisBlock.setBody(body);
		blocks.add(genesisBlock);
	}
	
	private static Header createGenesisHeader() {
		Header header = new Header();
		header.setPrv_hash("");
		header.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		header.setVersion(version);
		header.setNonce("123456");
		header.setDifficulty("789");
		header.setMerkleRootHash("");
		return header;
	}
	
	private static Body createGenesisBody() {
		Body body = new Body();
		body.setTxs(new ArrayList<>());
		return body;
	}

}
