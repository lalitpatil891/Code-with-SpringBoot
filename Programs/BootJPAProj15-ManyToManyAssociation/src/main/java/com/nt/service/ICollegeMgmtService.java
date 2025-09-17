package com.nt.service;

import com.nt.entity.Faculty;
import com.nt.entity.Student;

public interface ICollegeMgmtService {
    public  String   registerFacultiesAndStudents(Iterable<Faculty> list);
    public  String   registerStudentsAndFaculties(Iterable<Student> list);
    public   Iterable<Faculty>  showFacultiesAndTheirStudents();
    public   String    removeStudentsFromAFaculty(Iterable<Integer> sids, int fid);
    
}
