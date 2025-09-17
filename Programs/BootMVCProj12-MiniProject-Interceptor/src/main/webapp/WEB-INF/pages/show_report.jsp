<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>



<h1  style="color:red;text-align:center"> report page </h1>

<c:choose>
  <c:when  test="${!empty listVO}">
  
  <table border="1" bgcolor="yellow" align="center"> 
    <tr  bgcolor="cyan">
      <th> aid </th>
      <th> aname </th>
      <th> addrs </th>
      <th> category </th>
      <th> fee </th>
      <th> operations </th>
    </tr>
     <c:forEach  var="vo" items="${listVO}">
       <tr>
         <td>${vo.aid}</td>
         <td>${vo.aname}</td>
         <td>${vo.addrs}</td>
         <td>${vo.category}</td>
         <td>${vo.fee}</td>
         <td> <a href="edit?no=${vo.aid}"><img src="images/edit.jpg" width="30" height="30">
                    &nbsp; &nbsp;&nbsp;&nbsp;
                    <a href="remove?no=${vo.aid}"  onclick="return confirm('Do u want to delete ?')"><img src="images/delete.jpg" width="30" height="30">
                    </a>  </td>
       </tr>
     </c:forEach>
 </table>
  </c:when>
  <c:otherwise>
               <h1  style="color:red;text-align:center">Records not found </h1>
  </c:otherwise>
 </c:choose>
 <br> <h1 style="color:green;text-align:center;text-decoration:blink"> ${resultMsg} </h1> 
 <br><br>
 <h1  style="text-align:center"><a href="register"><img src="images/add.jpg" width="40" height="60"/> Add Actor</a></h1>
 
 <br><br>
 
 <h1  style="text-align:center"><a href="./"><img src="images/home.jpg"></a></h1>
 