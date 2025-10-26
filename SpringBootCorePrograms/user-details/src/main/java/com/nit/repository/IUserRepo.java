package com.nit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nit.entity.User;

@Repository
public interface IUserRepo extends CrudRepository<User, Long> {

}
