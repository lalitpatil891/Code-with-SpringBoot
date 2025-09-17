//Faculty.java
package com.nt.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer fid;
	
	@NonNull
	@Column(length = 30)
	private  String name;
	
	@NonNull
	@Column(length = 30)
	private  String  addrs;
	
	@NonNull
	@Column(length = 30)
	private   String subject;
	
	@ManyToMany(targetEntity = Student.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "FACULTIES_STUDENTS",joinColumns = @JoinColumn(name="faculty_id",referencedColumnName = "fid"),
	                        inverseJoinColumns = @JoinColumn(name="student_id",referencedColumnName = "sid"))
	private Set<Student>  students=new HashSet<Student>();

	
	
	//toString()
	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", name=" + name + ", addrs=" + addrs + ", subject=" + subject + "]";
	}
	

}
