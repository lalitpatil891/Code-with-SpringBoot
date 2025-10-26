//IDoctorRepo.java
package com.nit.repository;

import org.springframework.data.repository.CrudRepository;
import com.nit.entity.User;

public interface IUserRepo extends CrudRepository<User, Integer> {

}
