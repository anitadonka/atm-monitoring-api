package com.example.atm_monitoring_api.dtos;



public class CustomerCountResponse {

    private int customerCount;

    public CustomerCountResponse() {}

    public CustomerCountResponse(int customerCount) {
        this.customerCount = customerCount;
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(int customerCount) {
        this.customerCount = customerCount;
    }
}

