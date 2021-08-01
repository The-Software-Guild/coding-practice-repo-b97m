package com.bm.vendingmachine.service;

import java.math.BigDecimal;

/**
 * ...
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Aug 1, 2021
 */
public enum Coin {
    QUARTER(new BigDecimal("0.25")),
    DIME(new BigDecimal("0.10")),
    NICKEL(new BigDecimal("0.05")),
    PENNY(new BigDecimal("0.01"));
    
    private BigDecimal value;
    private Coin(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
    
    public String repName() {
        return this.toString().charAt(0)
                + this.toString().substring(1).toLowerCase();
    }
}
