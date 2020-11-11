package com.carsonlius.boot.service.impl;

import com.carsonlius.boot.service.TestFilterService;
import org.springframework.stereotype.Service;

@Service
public class TestFilterServiceImpl implements TestFilterService {
    @Override
    public void printFlag(String flag) {
        System.out.println(flag+ "打印测试标记 🙆‍♂️ =====================》 测试service是否可以被正常的注入到filter和interceptor");
    }
}
