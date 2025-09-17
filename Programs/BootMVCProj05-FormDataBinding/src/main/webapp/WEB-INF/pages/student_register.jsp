<%@ page isELIgnored="false"%>


<h1  style="color:red;text-align:center">Student Registration Page</h1>

<form    method="POST">
   <table  bgcolor="cyan"  align="center">
    <tr>
      <td>Student Id::</td>
      <td> <input type="text" name="sno"> </td>
    </tr>
    
    <tr>
      <td>Student Name::</td>
      <td> <input type="text" name="sname"> </td>
    </tr>
    
    <tr>
      <td>Student Address::</td>
      <td> <input type="text" name="sadd"> </td>
    </tr>
    
    <tr>
      <td>Student Avg::</td>
      <td> <input type="text" name="avg"> </td>
    </tr>
    
    <tr>
      <td><input type="submit" value="register"></td>
      <td> <input type="reset" value="cancel"> </td>
    </tr>
   </table>
</form>