package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.JobSeeker;
import com.nt.service.IJobSeekerMgmtService;

@Component
public class PLSQLTestRunner implements CommandLineRunner {
	@Autowired
	private IJobSeekerMgmtService  jsService;

	@Override
	public void run(String... args) throws Exception {
		try {
		 List<JobSeeker>  list=jsService.showAllJobSeekersByExpSalaryRange(60000.0, 10000000.0);
		 list.forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
