package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.BankAccount;
import com.nt.service.IBankAccountMgmtService;

@Component
public class VersioningAndTimestampTestRunner implements CommandLineRunner {
	@Autowired
	private IBankAccountMgmtService  accountService;

	@Override
	public void run(String... args) throws Exception {
		
		/*try {
			BankAccount  account=new BankAccount("raja","savings",5000.0);
			String  msg=accountService.openAcccount(account);
			System.out.println(msg);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			BankAccount  account=accountService.showAccountDetailsById(100000000L);
			System.out.println(account);
			System.out.println("------------------------------");
			String msg=accountService.withdrawAmount(100000000L, 100.0);
			System.out.println(msg);
			 account=accountService.showAccountDetailsById(100000000L);
			 System.out.println(account);
			 System.out.println("account modified for ::"+account.getUpdateCount()+"times,  opened at::"+account.getCreatedOn()+" lastly updated at::"+account.getLastUpdatedOn());
				System.out.println("------------------------------");
				String msg1=accountService.depositeAmount(100000000L, 100000.0);
				System.out.println(msg1);
				 account=accountService.showAccountDetailsById(100000000L);
				 System.out.println(account);
				 System.out.println("account modified for ::"+account.getUpdateCount()+"times,  opened at::"+account.getCreatedOn()+" lastly updated at::"+account.getLastUpdatedOn());
						
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
