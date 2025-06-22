package com.insight.controller;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@SupportUserType(UserType.BIG)
public class BigCustomer implements CustomerService {




    @Override
    public String findCustomer() {
        System.out.println("大R玩家客服");
        return "大R玩家客服";
    }
}