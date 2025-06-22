package com.insight.controller;

import org.springframework.stereotype.Component;

@Component
public class DefaultCustomer implements CustomerService {

    @Override
    public String findCustomer() {
        System.out.println("没有客服");
        return "没有客服";
    }
}