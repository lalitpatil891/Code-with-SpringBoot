package com.nit.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.BootDataJpAproj9CustomMethodsFinderMethods;
import com.nit.entity.JobSeeker;
import com.nit.repository.IJobSeekerRepository;

@Component
public class CustomFinderMethodsTestRunner implements CommandLineRunner {

	// Injecting main application class (optional dependency)
	private final BootDataJpAproj9CustomMethodsFinderMethods BootDataJpAproj9CustomMethodsFinderMethods;

	// Injecting Repository to perform DB operations
	@Autowired
	private IJobSeekerRepository repo;

	// Constructor-based dependency injection
	public CustomFinderMethodsTestRunner(
			BootDataJpAproj9CustomMethodsFinderMethods bootDataJpAproj9CustomMethodsFinderMethods) {
		this.BootDataJpAproj9CustomMethodsFinderMethods = bootDataJpAproj9CustomMethodsFinderMethods;
	}

	@Override
	public void run(String... args) throws Exception {

		/* ---------------------------------------------------------------------
		   EXAMPLE-1 : Fetch JobSeekers by ADDRESS using different finder methods
		   ---------------------------------------------------------------------
		try {
			//List<JobSeeker> list = repo.findByJsaddrsEquals("Pune");
			//List<JobSeeker> list = repo.readByJsaddrsIs("Pune");
			List<JobSeeker> list = repo.getByJsaddrs("Hyderabad");

			list.forEach(System.out::println);
		}
		catch (Exception e) {
			e.printStackTrace();
		} */

		
		
		/* ---------------------------------------------------------------------
		   EXAMPLE-2 : Fetch JobSeekers by SALARY RANGE
		   ---------------------------------------------------------------------
		try {
			// Between salary using range
			// List<JobSeeker> list = repo.findByExpectedSalaryBetween(30000, 40000);

			// Salary >= start AND salary <= end
			List<JobSeeker> list = repo
					.findByExpectedSalaryGreaterThanEqualAndExpectedSalaryLessThanEqual(10000.0, 100000.0);

			list.forEach(System.out::println);
		}
		catch (Exception e) {
			e.printStackTrace();
		} */



		/* ---------------------------------------------------------------------
		   EXAMPLE-3 : Fetch JobSeekers using pattern matching (LIKE, CONTAINING)
		   ---------------------------------------------------------------------
		try {
			// repo.findByJsaddrsInOrderByJsnameDesc(List.of("Pune","Nagpur","Hyderabad"))
			// 		.forEach(System.out::println);

			// repo.findByJsnameStartingWith('p').forEach(System.out::println);
			// repo.findByJsnameEndingWith('l').forEach(System.out::println);
			// repo.findByJsnameContaining("aja").forEach(System.out::println);
			// repo.findByJsnameEqualsIgnoreCase("KAJAL").forEach(System.out::println);
		}
		catch(Exception e) {
			e.printStackTrace();
		} */



		/* ---------------------------------------------------------------------
		   EXAMPLE-4 : Logical operations (LIKE, NOT IN, NOT LIKE)
		   --------------------------------------------------------------------- */
		try {
			// Fetch jobseekers from Pune having qualification in given list
			// repo.findByJsaddrsLikeAndQlfyIn("Pune", List.of("B.Tech","B.E"))
			// 		.forEach(System.out::println);

			// Fetch jobseekers NOT from given addresses OR qualification NOT like given pattern
			repo.findByJsaddrsNotInOrQlfyNotLike(List.of("Pune", "Mumbai"), "B")
					.forEach(System.out::println);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
