package com.insight.controller;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@SupportUserType(UserType.PERSONAL)
public class PersonalCustomer implements CustomerService {



    @Override
    public String findCustomer() {
        System.out.println("专属玩家客服");
        return "专属玩家客服";
    }
}