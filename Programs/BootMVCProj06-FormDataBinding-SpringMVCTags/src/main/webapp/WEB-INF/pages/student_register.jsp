<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm" %>


<h1  style="color:red;text-align:center">Student Registration Page</h1>

<frm:form     modelAttribute="stud">
   <table  bgcolor="cyan"  align="center">
    <tr>
      <td>Student Id::</td>
      <td> <frm:input  path="sno"/> </td>
    </tr>
    
    <tr>
      <td>Student Name::</td>
      <td> <frm:input  path="sname"/> </td>
    </tr>
    
    <tr>
      <td>Student Address::</td>
      <td> <frm:input   path="sadd"/> </td>
    </tr>
    
    <tr>
      <td>Student Avg::</td>
      <td> <frm:input  path="avg"/> </td>
    </tr>
    
    <tr>
      <td><input type="submit" value="register"></td>
      <td> <input type="reset" value="cancel"> </td>
    </tr>
   </table>
</frm:form>