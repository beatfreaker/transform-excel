package com.example.demo.model;

public class Data {

    private String id;
    private String quantity;
    private String amount;
    private String nonBillableQuantity;
    private String nonBillableAmount;
    private String notional;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getNonBillableQuantity() {
        return nonBillableQuantity;
    }

    public void setNonBillableQuantity(String nonBillableQuantity) {
        this.nonBillableQuantity = nonBillableQuantity;
    }

    public String getNonBillableAmount() {
        return nonBillableAmount;
    }

    public void setNonBillableAmount(String nonBillableAmount) {
        this.nonBillableAmount = nonBillableAmount;
    }

    public String getNotional() {
        return notional;
    }

    public void setNotional(String notional) {
        this.notional = notional;
    }
}
