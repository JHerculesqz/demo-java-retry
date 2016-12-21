package com.huawei.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetryController {
	// #region Fields

	@Autowired
	private RetryService retryService;

	// #endregion

	// #region hello

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return this.retryService.hello();
	}

	// #endregion
}
