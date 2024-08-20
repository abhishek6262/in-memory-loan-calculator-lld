package Entities;

import Enums.EmiStatus;

import java.util.Date;

public class Emi {
    public Date paidAt;
    public EmiStatus status = EmiStatus.UNPAID;

    public void markPaid() {
        this.paidAt = new Date();
        this.status = EmiStatus.PAID;
    }
}
