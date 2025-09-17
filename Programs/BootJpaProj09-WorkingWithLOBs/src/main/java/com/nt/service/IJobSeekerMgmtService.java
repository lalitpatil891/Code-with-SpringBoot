package com.nt.service;

import com.nt.entity.JobSeeker;

public interface IJobSeekerMgmtService {
    public  String  registerJobSeeker(JobSeeker seeker);
    public   JobSeeker  showJobSeekerById(int id);
}
