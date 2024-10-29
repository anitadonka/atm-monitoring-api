package com.example.atm_monitoring_api.dtos;



public class TransactionBreakdownResponse {

    private int depositCount;
    private int withdrawalCount;
    private int balanceInquiryCount;
    private int transactionType;

    public TransactionBreakdownResponse() {}

    public TransactionBreakdownResponse(int depositCount, int withdrawalCount, int balanceInquiryCount) {
        this.depositCount = depositCount;
        this.withdrawalCount = withdrawalCount;
        this.balanceInquiryCount = balanceInquiryCount;
    }

    public int getDepositCount() {
        return depositCount;
    }

    public void setDepositCount(int depositCount) {
        this.depositCount = depositCount;
    }

    public int getWithdrawalCount() {
        return withdrawalCount;
    }

    public void setWithdrawalCount(int withdrawalCount) {
        this.withdrawalCount = withdrawalCount;
    }

    public int getBalanceInquiryCount() {
        return balanceInquiryCount;
    }

    public void setBalanceInquiryCount(int balanceInquiryCount) {
        this.balanceInquiryCount = balanceInquiryCount;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }
}

