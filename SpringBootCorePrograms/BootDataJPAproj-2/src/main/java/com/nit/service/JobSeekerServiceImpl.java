package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.JobSeeker;
import com.nit.repository.IJobSeekerRepo;

@Service("jobSeekerService")
public class JobSeekerServiceImpl implements IJobSeekerService {

    @Autowired
    private IJobSeekerRepo repo;
	
    @Override
    public String registerJobSeeker(JobSeeker js) {
        JobSeeker jobSeeker = repo.save(js);
        return "JobSeeker obj is saved with id value " + jobSeeker.getJobId();
    }
}
