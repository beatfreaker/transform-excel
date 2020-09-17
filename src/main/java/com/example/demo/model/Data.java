package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

    @JsonProperty("CUSIP")
    private String cusip;
    private String category;
    private String trans;
    private String status;
    private String type;
    private String orders;
    private long quantity;
    private String amount;
    private String nonBillableQuantity;
    private long nonBillableOrders;
    private long qtyForNonBillableOrder;
    private long notional;
    private long nonBillableNotional;

    public String getCusip() {
        return cusip;
    }

    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
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

    public long getNonBillableOrders() {
        return nonBillableOrders;
    }

    public void setNonBillableOrders(long nonBillableOrders) {
        this.nonBillableOrders = nonBillableOrders;
    }

    public long getQtyForNonBillableOrder() {
        return qtyForNonBillableOrder;
    }

    public void setQtyForNonBillableOrder(long qtyForNonBillableOrder) {
        this.qtyForNonBillableOrder = qtyForNonBillableOrder;
    }

    public long getNotional() {
        return notional;
    }

    public void setNotional(long notional) {
        this.notional = notional;
    }

    public long getNonBillableNotional() {
        return nonBillableNotional;
    }

    public void setNonBillableNotional(long nonBillableNotional) {
        this.nonBillableNotional = nonBillableNotional;
    }
}
