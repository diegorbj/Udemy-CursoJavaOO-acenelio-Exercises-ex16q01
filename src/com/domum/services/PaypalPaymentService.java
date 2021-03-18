package com.domum.services;

import com.domum.entities.Contract;
import com.domum.entities.Installment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaypalPaymentService implements PaymentService{
    private static final double PAYMENT_INTEREST = 0.01;
    private static final double PAYMENT_FEE = 0.02;

    public Double paymentFee(Double amount) {
        return amount * PAYMENT_FEE;
    }

    public Double interest(Double amount, Integer month){
        return amount * PAYMENT_INTEREST * month;
    }
}
