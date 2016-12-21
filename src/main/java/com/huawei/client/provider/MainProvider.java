package com.huawei.client.provider;

import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;

import com.huawei._1_fw.retry.RetryUtilsEx;

public class MainProvider {
	// #region Const

	public static final int MAX_ATTEMPTS = 3;

	public static final int TIMEOUT = 1000;

	public static final int BACK_OFF_PERIOD = 200;

	// #endregion

	// #region hello

	public static String hello() {
		String strRes = RetryUtilsEx.retry(MAX_ATTEMPTS, TIMEOUT, BACK_OFF_PERIOD,
				new RetryCallback<String, Exception>() {
					@Override
					public String doWithRetry(RetryContext context) throws Exception {
						return String.valueOf(3 / 0);
					}
				}, new RecoveryCallback<String>() {
					@Override
					public String recover(RetryContext context) throws Exception {
						System.out.println("recovery");
						return "recovery";
					}
				});

		return strRes;
	}

	// #endregion
}
