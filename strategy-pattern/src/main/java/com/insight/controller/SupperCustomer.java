package com.insight.controller;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@SupportUserType(UserType.SUPPER)
public class SupperCustomer implements CustomerService {

    @Override
    public String findCustomer() {
        System.out.println("超级R玩家客服");
        return "超级R玩家客服";
    }
}