package com.insight.controller;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@SupportUserType(UserType.NORMAL)
public class NormalCustomer implements CustomerService {



    @Override
    public String findCustomer() {
        System.out.println("普通玩家客服");
        return "普通玩家客服";
    }
}