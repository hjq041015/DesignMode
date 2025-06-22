package com.insight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    private Map<UserType,CustomerService> customerServiceMap;

    @Autowired
    DefaultCustomer defaultCustomer;

    @Autowired
    public void setCustomerServiceMap(List<CustomerService> customerServicesList) {
        this.customerServiceMap =
        customerServicesList.stream()
                .filter(customerService -> customerService.getClass().isAnnotationPresent(SupportUserType.class))
                .collect(Collectors.toMap(this::findUserType, Function.identity()));
        if (this.customerServiceMap.size() != UserType.values().length) {
            throw new IllegalArgumentException("用用户类型没有对应的策略");
        }

    }



    @GetMapping("/findCustomer/{recharge}")
    public String findCustomer(@PathVariable(value = "recharge") int recharge) {
        UserType userType = UserType.typeOf(recharge);
        CustomerService customerService = customerServiceMap.getOrDefault(userType,defaultCustomer);
        return customerService.findCustomer();

    }

    private UserType findUserType(CustomerService customerService) {
        SupportUserType annotation = customerService.getClass().getAnnotation(SupportUserType.class);
        return annotation.value();
    }



}