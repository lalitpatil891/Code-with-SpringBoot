package com.nt.service;

import org.springframework.data.repository.query.Param;

import com.nt.entity.BankAccount;

public interface IBankAccountMgmtService {
    public  String  openAcccount(BankAccount  account);
    public   String  withdrawAmount(long acno, double amount);
    public   String  depositeAmount(long acno, double amount);
    public   BankAccount   showAccountDetailsById(long acno);
    
}
