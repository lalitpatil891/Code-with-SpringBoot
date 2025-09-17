package com.nt.service;

import java.util.List;
import java.util.Set;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Faculty;
import com.nt.entity.Student;
import com.nt.repository.IFacultyRepository;
import com.nt.repository.IStudentRepository;

@Service
public class CollegeMgmtServiceImpl implements ICollegeMgmtService {
	@Autowired
	private   IFacultyRepository  facultyRepo;
	@Autowired
	private   IStudentRepository  studRepo;

	@Override
	public String registerFacultiesAndStudents(Iterable<Faculty> list) {
		//save the object
		Iterable<Faculty>  savedList=facultyRepo.saveAll(list);
		long count=StreamSupport.stream(savedList.spliterator(), true).count();
		return count+" no.of  faculties and thier students are saved";
	}
	
	@Override
	public String registerStudentsAndFaculties(Iterable<Student> list) {
		Iterable<Student> savedList=studRepo.saveAll(list);
		long count=StreamSupport.stream(savedList.spliterator(), true).count();
		return count+" no.of  students and thier faculties are saved";
	}
	
	@Override
	public Iterable<Faculty> showFacultiesAndTheirStudents() {
		return facultyRepo.findAll();
	}
	
	@Override
	@Transactional
	public String removeStudentsFromAFaculty(Iterable<Integer> sids, int fid) {
		//Load  Students
		List<Student>  list=studRepo.findAllById(sids);
		//Load faculty
		Faculty  fac1=facultyRepo.findById(fid).orElseThrow(()->new IllegalArgumentException("invalid id"));
		// get all the students of  a faculty
	   Set<Student>  childs=fac1.getStudents();
	   childs.removeAll(list);
	   //update the faculty
	   facultyRepo.save(fac1);
		
		return "removed "+sids+"  students from  "+fid+" faculty";
	}

}
