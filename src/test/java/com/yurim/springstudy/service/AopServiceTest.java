package com.yurim.springstudy.service;

import com.yurim.springstudy.SpringStudyApplication;
import com.yurim.springstudy.service.aop.AopInterface;
import com.yurim.springstudy.service.aop.CGLIBProxyService;
import com.yurim.springstudy.service.aop.JdkDynamicProxyService;
import java.lang.reflect.Proxy;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.aop.proxy-target-class=false") // ✅ JDK 동적 프록시 강제
public class AopServiceTest {

    @Autowired
    private AopInterface aopInterface;

    @Autowired
    private CGLIBProxyService cglibProxyService;

    @Test
    public void testJdkProxy() {
        System.out.println("AopInterface 프록시 클래스: " + aopInterface.getClass());
        System.out.println("CGLIBProxyService 프록시 클래스: " + cglibProxyService.getClass());

        boolean isJdkProxy = Proxy.isProxyClass(aopInterface.getClass());
        System.out.println("JDK 프록시 사용 여부: " + isJdkProxy);

        boolean isCglibProxy = AopProxyUtils.ultimateTargetClass(aopInterface) != aopInterface.getClass();
        System.out.println("CGLIB 프록시 사용 여부: " + isCglibProxy);
    }
}