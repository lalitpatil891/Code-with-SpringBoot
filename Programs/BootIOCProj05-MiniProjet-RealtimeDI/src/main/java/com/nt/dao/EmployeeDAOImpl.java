package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {
	private   static  final String GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	private  static  final  String  INSERT_EMP_QUERY="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(ENO_SEQ1.NEXTVAL,?,?,?)"; 
	
	@Autowired
	private DataSource  ds;

	@Override
	public List<Employee> showEmployessByDesgs(String desg1, String desg2, String desg3) throws Exception {
		System.out.println("DataSource obj class name::"+ds.getClass());
		 List<Employee>  list=null;
		try(  //get Pooled jdbc con object
				Connection con=ds.getConnection();
				//create PreparedSTatement object
				PreparedStatement  ps=con.prepareStatement(GET_EMPS_BY_DESGS);
				){
				//set values to Queyr params
			     ps.setString(1, desg1);
			     ps.setString(2, desg2);
			     ps.setString(3,desg3);
				//execute the Query
			     try(ResultSet rs=ps.executeQuery()){
			    	  //copy ResultSEt obj  records to  ArrayList Collection
			    	   list=new ArrayList<Employee>();
			    	   while(rs.next()) {
			    		   Employee emp=new Employee();
			    		   emp.setEno(rs.getInt(1));
			    		   emp.setEnmae(rs.getString(2));
			    		   emp.setDesg(rs.getString(3));
			    		   emp.setSalary(rs.getFloat(4));
			    		   list.add(emp);
			    	   }//while
			     }//try2
		}//try1
		catch(SQLException se) {
			throw se;  //Exception Rethrowing 
		}
		catch(Exception  e) {
			throw e;  //Exception ReThrowing
		}
			return list;
	}
	
	public   int    insert(Employee emp)throws Exception{
		try( //get Pooled JDBC Con object 
				Connection con=ds.getConnection();
				// create JDBC PRpearedStatement object
				PreparedStatement ps=con.prepareStatement(INSERT_EMP_QUERY);
				){
			//set values to Query params
			 ps.setString(1,emp.getEnmae());
			 ps.setString(2,emp.getDesg());
			 ps.setDouble(3, emp.getSalary());
			 //execute the SQL Query
			 int result=ps.executeUpdate();
			return result;
		}
		catch(SQLException se) {
			se.printStackTrace();
			return 0;
		}
		catch(Exception  e) {
			e.printStackTrace();
			return 0;
		}
	}


}
