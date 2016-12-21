# 目的#
 
实验Spring-Retry
	
# 步骤 #

**STEP1.Gradle中引用依赖的jar**
	
	compile('org.springframework.retry:spring-retry:1.1.2.RELEASE')
	
**STEP2.实现RetryUtilsEx.java**
	
	核心是RetryTemplate，详见RetryUtilsEx
	
**STEP3.在调用方使用RetryUtilsEx.java**

# reference #
	
	http://iyiguo.net/blog/2016/01/19/spring-retry-common-case/
	http://docs.spring.io/spring-batch/reference/html/retry.html
	http://www.cnblogs.com/rollenholt/p/4711441.html
	http://www.voidcn.com/blog/Revivedsun/article/p-6328127.html
	TODO:FixedBackOffPolicy未生效