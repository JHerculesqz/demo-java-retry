package com.huawei.client;

import org.springframework.stereotype.Service;

import com.huawei.client.provider.MainProvider;

@Service
public class RetryService {
	// #region hello

	public String hello() {
		return MainProvider.hello();
	}

	// #endregion
}
