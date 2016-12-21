package com.huawei._1_fw.retry;

import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.CompositeRetryPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.policy.TimeoutRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

public class RetryUtilsEx {
	// #region retry

	public static <T> T retry(int iMaxAttempts, int iTimeout, int iBackOffPeriod,
			RetryCallback<T, Exception> oCallbackRetry, RecoveryCallback<T> oCallbackRecovery) {
		// 1.new RetryTemplate
		RetryTemplate oRetryTemplate = new RetryTemplate();

		// 2.generate policy
		CompositeRetryPolicy oCompositeRetryPolicy = new CompositeRetryPolicy();
		// 2.1.设置重试的次数
		SimpleRetryPolicy oSimpleRetryPolicy = new SimpleRetryPolicy();
		oSimpleRetryPolicy.setMaxAttempts(iMaxAttempts);
		// 2.2.设置重试的timeout
		TimeoutRetryPolicy oTimeoutRetryPolicy = new TimeoutRetryPolicy();
		oTimeoutRetryPolicy.setTimeout(iTimeout);
		// 2.3.设置间隔多长时间重试一次
		// TODO:？？？
		FixedBackOffPolicy oFixedBackOffPolicy = new FixedBackOffPolicy();
		oFixedBackOffPolicy.setBackOffPeriod(iBackOffPeriod);
		// 2.4.set to oCompositeRetryPolicy
		oCompositeRetryPolicy.setPolicies(new RetryPolicy[] { oSimpleRetryPolicy, oTimeoutRetryPolicy });
		oRetryTemplate.setRetryPolicy(oCompositeRetryPolicy);

		// 3.
		T oRes = null;
		try {
			oRes = oRetryTemplate.execute(oCallbackRetry, oCallbackRecovery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return oRes;

	}

	// #endregion
}
