package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.BankAccount;
import com.nt.repository.IBankAccountRepository;

@Service
public class BankAccountMgmtSericeImpl implements IBankAccountMgmtService {
	@Autowired
	private IBankAccountRepository  accountRepo;

	@Override
	public String openAcccount(BankAccount account) {
		//save the object
		account.setCreatedBy(System.getProperty("user.name")); 
		long idVal=accountRepo.save(account).getAcno();
		return  "Account is opened having account number::"+idVal;
	}
	
	@Override
	public String withdrawAmount(long acno, double amount) {
       //Load object  
		BankAccount  account=accountRepo.findById(acno).orElseThrow(()-> new IllegalArgumentException("invalid account number"));
		  //modify balance
		account.setBalance(account.getBalance()-amount);
		account.setUpdatedBy(System.getProperty("user.name"));
		
		//update the object
		   accountRepo.save(account);
			return  amount+"  is withdrawn from the  account "+acno;
	}
	
	@Override
	public String depositeAmount(long acno, double amount) {
		   //Load object  
				BankAccount  account=accountRepo.findById(acno).orElseThrow(()-> new IllegalArgumentException("invalid account number"));
				  //modify balance
				account.setBalance(account.getBalance()+amount);
				account.setUpdatedBy(System.getProperty("user.name"));
				//update the object
				   accountRepo.save(account);
					return  amount+"  is deposited  into the  account "+acno;
	}
	
	@Override
	public BankAccount showAccountDetailsById(long acno) {
		//Load object
		BankAccount  account=accountRepo.findById(acno).orElseThrow(()-> new IllegalArgumentException("invalid account number"));
		
		return account;
	}

}
