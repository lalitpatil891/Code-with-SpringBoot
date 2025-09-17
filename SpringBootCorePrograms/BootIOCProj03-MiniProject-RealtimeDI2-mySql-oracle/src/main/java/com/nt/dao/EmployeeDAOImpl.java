package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

    @Autowired
    @Qualifier("oracleDataSource")
    private DataSource oracleDs;

    @Autowired
    @Qualifier("mysqlDataSource")
    private DataSource mysqlDs;

    private static final String ORACLE_SELECT = "SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE JOB IN (?, ?, ?)";
    private static final String MYSQL_SELECT  = "SELECT EMPNO, ENAME, JOB, SALARY FROM EMPLOYEE WHERE JOB IN (?, ?, ?)";

//    private static final String ORACLE_INSERT = "INSERT INTO EMP(EMPNO, ENAME, JOB, SAL) VALUES(EMP_SEQ.NEXTVAL, ?, ?, ?)";
//    private static final String MYSQL_INSERT  = "INSERT INTO EMP(ENAME, JOB, SALARY) VALUES(?, ?, ?)";

    @Override
    public List<Employee> showEmployeeByDesgs(String desg1, String desg2, String desg3, String dbType) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Employee> list = new ArrayList<>();

        try {
            if ("oracle".equalsIgnoreCase(dbType)) {
                con = oracleDs.getConnection();
                ps = con.prepareStatement(ORACLE_SELECT);
            } else {
                con = mysqlDs.getConnection();
                ps = con.prepareStatement(MYSQL_SELECT);
            }

            ps.setString(1, desg1);
            ps.setString(2, desg2);
            ps.setString(3, desg3);

            rs = ps.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmpno(rs.getInt(1));
                emp.setEname(rs.getString(2));
                emp.setJob(rs.getString(3));
                emp.setSalary(rs.getDouble(4));
                list.add(emp);
            }
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        }
        return list;
    }

    @Override
    public int insertEmployee(Employee emp, String dbType) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;

        // Use correct column names
        String INSERT_EMP_ORACLE = "INSERT INTO EMP(EMPNO, ENAME, JOB, SAL) VALUES(EMP_SEQ.NEXTVAL, ?, ?, ?)";
        String INSERT_EMP_MYSQL = "INSERT INTO EMP(ENAME, JOB, SAL) VALUES(?, ?, ?)";

        try {
            if("oracle".equalsIgnoreCase(dbType)) {
                con = oracleDs.getConnection();
                ps = con.prepareStatement(INSERT_EMP_ORACLE);
                ps.setString(1, emp.getEname());
                ps.setString(2, emp.getJob());
                ps.setDouble(3, emp.getSalary());
            } else {
                con = mysqlDs.getConnection();
                ps = con.prepareStatement(INSERT_EMP_MYSQL);
                ps.setString(1, emp.getEname());
                ps.setString(2, emp.getJob());
                ps.setDouble(3, emp.getSalary());
            }

            return ps.executeUpdate();
        }
        finally {
            if(ps != null) ps.close();
            if(con != null) con.close();
        }
    }

}
