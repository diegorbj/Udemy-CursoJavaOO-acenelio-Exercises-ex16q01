package com.domum.services;

import com.domum.entities.Contract;
import com.domum.entities.Installment;
import java.util.List;

public interface PaymentService {
    Double paymentFee(Double amount);
    Double interest(Double amount, Integer month);
}
