package com.insight.controller;

import java.util.function.IntPredicate;

public enum UserType {
    NORMAL(recharge -> recharge >= 0 && recharge < 100),
    SMALL(recharge -> recharge >= 100 && recharge < 1000),
    BIG(recharge -> recharge >= 1000 && recharge < 10000),
    SUPPER(recharge -> recharge >= 10000 && recharge < 100000),
    PERSONAL(recharge -> recharge >= 100000);

    private final IntPredicate support;

    UserType(IntPredicate support) {
        this.support = support;
    }

    public static UserType typeOf(int recharge) {
        for (UserType type : UserType.values()) {
            if (type.support.test(recharge)) {
                return type;
            }
        }
        return null;
    }
}