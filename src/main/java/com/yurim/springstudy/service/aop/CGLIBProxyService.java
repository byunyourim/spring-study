package com.yurim.springstudy.service.aop;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CGLIBProxyService {

    public void doSomething() {
        System.out.println("CGLIB Proxy 생성");
    }
}
