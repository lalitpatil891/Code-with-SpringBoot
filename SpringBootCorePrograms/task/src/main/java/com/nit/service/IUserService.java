package com.nit.service;

import java.util.List;
import java.util.Optional;

import com.nit.entity.User;

/**
 * Service interface that defines CRUD operations for Doctor entity.
 */
public interface IUserService {

    // Create
    String registerDoctor(User doctor);
    String registerDoctorsBatch(List<User> list);

    // Read
    long showDoctorsCount();
    boolean isDoctorAvailable(int id);
    Iterable<User> showAllDoctors();
    Iterable<User> findDoctorsById(Iterable<Integer> ids);
    User findDoctorById(int id);
    Optional<User> showDoctorById(int id);

    // Update
    String updateDoctorName(int id, String name);

    // Delete
    String delateDoctorById(int id);
    String deleteDoctorByEntity(User doctor);
    String removeAllDoctors();
    String removeDoctorsByIds(Iterable<Integer> ids);
}
