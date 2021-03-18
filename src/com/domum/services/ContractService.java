package com.domum.services;

import com.domum.entities.Contract;
import com.domum.entities.Installment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ContractService {
    private PaymentService paymentService;

    public ContractService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    private Date addMonths(Date date,  int months){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, months);
        return calendar.getTime();
    }

    public void processContract(Contract contract, int quotas) {
        List<Installment> instalments = new ArrayList<>();

        double baseAmount = contract.getTotalValue() / quotas;
        double quotaAmount;

        for (int quota = 1; quota <= quotas; quota++) {
            Date dueDate = addMonths(contract.getDate(), quota);

            quotaAmount = baseAmount;
            quotaAmount += paymentService.interest(baseAmount, quota);
            quotaAmount += paymentService.paymentFee(quotaAmount);

            Installment installment = new Installment(quota, dueDate, quotaAmount);

            contract.getInstallments().add(installment);
        }
    }
}
