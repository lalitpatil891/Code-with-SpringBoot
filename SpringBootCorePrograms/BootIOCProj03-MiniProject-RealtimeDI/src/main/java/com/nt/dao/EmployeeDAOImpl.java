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

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	@Autowired
	private DataSource ds; // Has-A property

	// SQL Query
	private static final String GET_EMPS_QUERY = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	
	private static final String INSERT_EMP_QUERY = "INSERT INTO EMP(EMPNO,ENAME,JOB,SAL,DEPTNO) VALUES(EMP_ID_SEQ.NEXTVAL,?,?,?,?)";
	
	
	@Override
	public List<Employee> showEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> list = null;

		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(GET_EMPS_QUERY)) {

			// Set values to query params
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);

			// Execute the SQL query
			try (ResultSet rs = ps.executeQuery()) {
				list = new ArrayList<>();
				while (rs.next()) {
					// Create and populate Employee object
					Employee emp = new Employee();
					emp.setEmpno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setJob(rs.getString(3));
					emp.setSalary(rs.getDouble(4));
					emp.setDeptno(rs.getInt(5));

					// Add to list
					list.add(emp);
				}
			}

		} catch (SQLException se) {
			se.printStackTrace();
			throw new RuntimeException(se); // Or a custom exception
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e); // Or a custom exception
		}

		return list; // ✅ Return the result
	}
	
	//===============Data Insert Operation-====================
	@Override
	public int insertEmployee(Employee emp) throws Exception {
		//get pooled jdbc con object
		try(
				Connection con = ds.getConnection();
				//create prepared Statement object
				PreparedStatement ps1 = con.prepareStatement(INSERT_EMP_QUERY); 
			){
			
			// set values to query params
			ps1.setString(1, emp.getEname());
			ps1.setString(2, emp.getJob());
			ps1.setDouble(3, emp.getSalary());
			ps1.setInt(4, emp.getDeptno());
			
			
			//execute the SQL query
			int count = ps1.executeUpdate();
			
			return count;
			
		}//try
		catch(SQLException se) {
			throw se;
		}
		catch(Exception e) {
			throw e;
		}
		
	
	}

}
