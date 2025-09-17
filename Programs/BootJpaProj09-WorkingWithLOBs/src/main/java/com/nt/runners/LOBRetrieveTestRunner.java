package com.nt.runners;

import java.io.FileOutputStream;
import java.io.FileWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.JobSeeker;
import com.nt.service.IJobSeekerMgmtService;

@Component
public class LOBRetrieveTestRunner implements CommandLineRunner {
	@Autowired
	private  IJobSeekerMgmtService  jsService;

	@Override
	public void run(String... args) throws Exception {
	  try {
		  JobSeeker  js=jsService.showJobSeekerById(10);
		  //read BLOB and BLOB  properties data
		  byte[] photoContent=js.getPhoto();
		  char[] resumeContent=js.getResume();
		  //convert  byte[] into   BLOB file using Streams
		  try(FileOutputStream  fos=new FileOutputStream("retrieve_photo.jpg")){
			             fos.write(photoContent);
			             fos.flush();
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  System.out.println("BLOB file is retrieved");

		//convert  char[] into  CLOB file using Streams
		  try(FileWriter  writer=new FileWriter("retrieve_resume.txt")){
			        writer.write(resumeContent);
			        writer.flush();
		  }
		  System.out.println("CLOB file is retrieved");
		  System.out.println("Job Seeker info::"+js.getJsid()+" "+js.getJsname()+"  "+js.getQlfy()+"  "+js.getExpectedSalary()+" "+js.getAddrs());
		  
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
		
	}

}
