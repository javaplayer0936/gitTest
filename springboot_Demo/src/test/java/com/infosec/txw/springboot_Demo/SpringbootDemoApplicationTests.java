package com.infosec.txw.springboot_Demo;

import com.infosec.txw.springboot_Demo.aop.LogAop;
import com.infosec.txw.springboot_Demo.aop.TransitionAop;
import com.infosec.txw.springboot_Demo.proxy.AopProxy;
import com.infosec.txw.springboot_Demo.proxy.LogProxy;
import com.infosec.txw.springboot_Demo.proxy.TeamService;
import com.infosec.txw.springboot_Demo.proxy.TransitionProxy;
import com.infosec.txw.springboot_Demo.service.ServiceAspectJ;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootDemoApplicationTests {

	public static final TransitionAop TRANSITION_AOP = new TransitionAop();

	@Autowired
	private ServiceAspectJ aspectJ;

	@Test
	void contextLoads() {
	}

	/**
	 * 多个代理类
	 */
	@Test
	public void testProxy() {
		//创建被代理类对象
		TeamService teamService = new TeamService();
		//创建事物代理类对象
		TransitionProxy transitionProxy = new TransitionProxy(teamService);
		//创建日志代理类对象
		LogProxy logProxy = new LogProxy(transitionProxy);
		//执行代理之后的方法
		logProxy.add(1,2);
	}

	/**
	 * AOP代理
	 */
	@Test
	public void testProxyAop() {
		//创建被代理对象
		TeamService teamService = new TeamService();
		//创建事务切面
		TransitionAop transitionAop = new TransitionAop();
		//创建日志切面
		LogAop logAop = new LogAop();
		//代理事务
		AopProxy aopProxy = new AopProxy(teamService, transitionAop);
		//代理日志
		AopProxy aopProxy1 = new AopProxy(aopProxy, logAop);
		//执行增强后的方法
		aopProxy1.service();
	}

	@Test
	public void AspectJTest() {
		aspectJ.add(2,1);
		aspectJ.delete(2,1);
		aspectJ.haha(null);
	}



}
