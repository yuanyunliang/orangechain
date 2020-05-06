package com.defang.orangechain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.defang.orangechain.service.RestRequestService;

/**
 * RestRequestServiceImpl
 * 
 */
@Service
public class RestRequestServiceImpl implements RestRequestService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public <T> T post(String url, String data, Class<T> clazz) {
		T json = restTemplate.postForEntity(url, data, clazz).getBody();
		return json;
	}

}
