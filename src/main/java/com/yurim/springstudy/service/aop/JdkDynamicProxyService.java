package com.yurim.springstudy.service.aop;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JdkDynamicProxyService implements AopInterface{

    @Override
    @Transactional
    public void doSomething() {

        System.out.println("JDK Dynamic Proxy 생성");
    }
}
