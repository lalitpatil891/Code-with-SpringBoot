package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.CollegeMgmtServiceImpl;
import com.nt.service.ICollegeMgmtService;

@Component
public class ManyToManyTestRunner implements CommandLineRunner {

    private final CollegeMgmtServiceImpl collegeMgmtServiceImpl;
	@Autowired
	private  ICollegeMgmtService collegeService;


    ManyToManyTestRunner(CollegeMgmtServiceImpl collegeMgmtServiceImpl) {
        this.collegeMgmtServiceImpl = collegeMgmtServiceImpl;
    }
	
	
	@Override
	public void run(String... args) throws Exception {
		/*try {
			Faculty fac1=new  Faculty("raja", "hyd", "java");
			Faculty fac2=new  Faculty("ramesh", "vizag", ".net");
			
			Student  stud1=new Student("chinna", "hyd", "MTech");
			Student  stud2=new Student("munna", "mumbai", "Bsc");
			Student  stud3=new Student("kanna", "canada", "MCA");
		
			// add students to faculities
			fac1.getStudents().add(stud1);
			fac1.getStudents().add(stud2);
			fac2.getStudents().add(stud1);
			fac2.getStudents().add(stud2);
			fac2.getStudents().add(stud3);
			
			//  add faculties to students
			stud1.getFaculties().add(fac1);
			stud1.getFaculties().add(fac2);
			stud2.getFaculties().add(fac1);
			stud2.getFaculties().add(fac2);
			stud3.getFaculties().add(fac2);
			//invoke the b.method
			String msg=collegeService.registerFacultiesAndStudents(Arrays.asList(fac1,fac2));
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			Faculty fac1=new  Faculty("tilochan", "odisha", "java");
			Faculty fac2=new  Faculty("yash", "bihar", "aws");
			
			Student  stud1=new Student("anil", "hyd", "BTech");
			Student  stud2=new Student("sunil", "mumbai", "MTech");
		
			// add students to faculities
			fac1.getStudents().add(stud1);
			fac1.getStudents().add(stud2);
			fac2.getStudents().add(stud1);
			
			//  add faculties to students
			stud1.getFaculties().add(fac1);
			stud1.getFaculties().add(fac2);
			stud2.getFaculties().add(fac1);
			//invoke the b.method
			String msg=collegeService.registerStudentsAndFaculties(Arrays.asList(stud1,stud2));
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		*/
		/*try {
			collegeService.showFacultiesAndTheirStudents().forEach(fac->{
				System.out.println("Faculty::"+fac);
				Set<Student>  childs=fac.getStudents();
				childs.forEach(st->{
					System.out.println("Student::"+st);
				});
				System.out.println("------------------");
			});
			
		}
		catch(Exception  e) {
			e.printStackTrace();
		}
		*/
		
		try {
			String msg=collegeService.removeStudentsFromAFaculty(List.of(1003,1004), 53);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
