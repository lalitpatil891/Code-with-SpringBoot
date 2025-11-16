package com.nt.service;

import java.util.List;

import com.nt.entity.JobSeeker;

public interface IJobSeekerMgmtService {
    public   List<JobSeeker>  showAllJobSeekersByExpSalaryRange(double start,double end);
}
