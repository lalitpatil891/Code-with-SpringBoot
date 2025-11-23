package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nit.entity.JobSeeker;

public interface IJobSeekerRepository extends JpaRepository<JobSeeker, Integer> {

	// Match address exactly
	List<JobSeeker> findByJsaddrsEquals(String addrs);

	// Same as equals (readBy...Is is just another naming pattern)
	List<JobSeeker> readByJsaddrsIs(String addrs);

	// Another alias for equality check
	List<JobSeeker> getByJsaddrs(String addrs);

	// Salary between two values (inclusive)
	List<JobSeeker> findByExpectedSalaryBetween(double start, double end);

	// Salary >= start AND Salary <= end
	List<JobSeeker> findByExpectedSalaryGreaterThanEqualAndExpectedSalaryLessThanEqual(double start, double end);

	// Fetch by city list sorted by name in descending order
	List<JobSeeker> findByJsaddrsInOrderByJsnameDesc(List<String> cities);

	// Name starting with character
	List<JobSeeker> findByJsnameStartingWith(char initChar);

	// Name ending with character
	List<JobSeeker> findByJsnameEndingWith(char initChar);

	// Name containing substring
	List<JobSeeker> findByJsnameContaining(String str);

	// Case-insensitive compare
	List<JobSeeker> findByJsnameEqualsIgnoreCase(String str);

	// Address like pattern AND qualification in list
	List<JobSeeker> findByJsaddrsLikeAndQlfyIn(String chars, List<String> qualifications);

	// Address NOT in list OR qualification NOT like given pattern
	List<JobSeeker> findByJsaddrsNotInOrQlfyNotLike(List<String> notAddrsList, String notQlfy);
}
