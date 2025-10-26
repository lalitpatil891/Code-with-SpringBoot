package com.nit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.User;
import com.nit.repository.IUserRepo;

import jakarta.transaction.Transactional;

@Service("userService")
public class IUserMgmtServiceImpl implements IUserService {

    @Autowired
    private IUserRepo doctorRepo;

    /* ======================== CREATE ======================== */

    @Override
    public String registerDoctor(User doctor) {
        return "Doctor saved with I: " + doctorRepo.save(doctor).getDocid();
    }

 
   
}