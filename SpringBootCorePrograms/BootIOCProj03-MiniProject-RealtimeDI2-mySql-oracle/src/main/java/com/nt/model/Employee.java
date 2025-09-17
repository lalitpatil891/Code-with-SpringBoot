package com.nt.model;
//java bean
public class Employee {
	//Java bean properties
	private Integer empno;
	private String ename;
	private String job;  // desg
	private Double salary;
	private Integer deptno;
	private Double grossSalary;
	private Double netSalary;
	
	//alt+shift+s,s(Setter and getter)
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer getDeptno() {
		return deptno;
	} 
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public Double getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(Double grossSalary) {
		this.grossSalary = grossSalary;
	}
	public Double getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(Double netSalary) {
		this.netSalary = netSalary;
	}
	
	//toString (alt+shipt+s,s)
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", job=" + job + ", salary=" + salary + ", deptno="
				+ deptno + ", grossSalary=" + grossSalary + ", netSalary=" + netSalary + "]";
	}
}
