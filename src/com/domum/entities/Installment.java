package com.domum.entities;

import java.util.Date;

public class Installment {
    private Integer number;
    private Date dueDate;
    private Double amount;

    public Installment() {
    }

    public Installment(Integer number, Date dueDate, Double amount) {
        this.number = number;
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date duaDate) {
        this.dueDate = duaDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
