package com.nt.runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.JobSeeker;
import com.nt.service.IJobSeekerMgmtService;

//@Component
public class LOBsInsertTestRunner implements CommandLineRunner {
	@Autowired
	private  IJobSeekerMgmtService  jsService;
	
	@Override
	public void run(String... args) throws Exception {
		try(Scanner sc=new Scanner(System.in)){
			System.out.println("enter js name");
			String name=sc.next();
			System.out.println("Enter addrs:");
			String addrs=sc.next();
			System.out.println("Enter qualification:");
			String qlfy=sc.next();
			System.out.println("Enter Expected  Salary:");
			double salary=sc.nextDouble();
			System.out.println("Enter photo file path:");
			String  photoPath=sc.next().trim();
			System.out.println("Enter resume file path:");
			String  resumePath=sc.next().trim();
			//Converting photo file content  to byte[]
			byte[]  photoContent=null;
			try(FileInputStream  fis=new FileInputStream(photoPath);){
			     photoContent=fis.readAllBytes();	    
			}
			catch(Exception  e) {
				e.printStackTrace();
			}
			//Converting resume file content  tochar[]
			File file=new File(resumePath);
			int length=(int)file.length();
			char[]  resumeContent=new char[length];
			try(FileReader reader=new FileReader(resumePath)) {
				   reader.read(resumeContent);
			}
			catch(Exception  e) {
				e.printStackTrace();
			}
			
			//prepare Entity class object
			   JobSeeker js=new JobSeeker();
			   js.setJsname(name);js.setAddrs(addrs);
			   js.setQlfy(qlfy); js.setExpectedSalary(salary);
			   js.setPhoto(photoContent); js.setResume(resumeContent);
			   //use the service
			   String msg=jsService.registerJobSeeker(js);
			   System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//main
}//class
