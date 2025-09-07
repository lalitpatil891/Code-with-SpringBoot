package com.lp.profile_demo.repository;

import com.lp.profile_demo.entity.Course;
import com.lp.profile_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long > {

}
