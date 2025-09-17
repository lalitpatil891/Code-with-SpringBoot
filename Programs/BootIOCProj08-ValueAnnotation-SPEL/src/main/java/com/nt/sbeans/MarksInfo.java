package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("marks")
@Data
public class MarksInfo {
	@Value("${stud.marks1}")
	private Integer m1;
	@Value("${stud.marks2}")
	private Integer m2;
	@Value("${stud.marks3}")
	private Integer m3;
	

}
