package com.nit.repository;

import org.springframework.data.repository.CrudRepository;

import com.nit.entity.JobSeeker;

public interface IJobSeekerRepo extends CrudRepository<JobSeeker, Integer> {

}
