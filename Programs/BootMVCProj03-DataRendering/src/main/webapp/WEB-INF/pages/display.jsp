<%@ page isELIgnored="false" import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>


<h1  style="color:blue;text-align:center"> Result Page</h1>

<b> Result is :: ${resultMsg}</b> <br>

<br> <a href="./">home <img src="home.jpeg"  width="100" height="100"> </a>  <br>

<hr>

<b>Model Attributes ::  ${name } , ${age}</b>  <br>
<hr>
<b> model attributes  :: ${nickNames}, <br> <%=Arrays.toString(((String[])request.getAttribute("nickNames")))%> 
        <br>  ${friends}   <br>
        <br>  ${phones}   <br>
        <br>  ${idDetails}   <br>
  </b>
  <hr>
  <br>
  <b> model attributes  ::  <br>
         <c:if test="${!empty nickNames}">
            <c:forEach  var="nn" items="${nickNames}">
                ${nn} <br>
            </c:forEach>
         </c:if>
         <br>
         <c:if test="${!empty friends}">
            <c:forEach  var="frn" items="${friends}">
                ${frn} <br>
            </c:forEach>
         </c:if>  <br>
          <c:if test="${!empty phones}">
            <c:forEach  var="ph" items="${phones}">
                ${ph} <br>
            </c:forEach>
         </c:if>
          <c:if test="${!empty idDetails}">
            <c:forEach  var="id" items="${idDetails}">
                <br>  ${id.key} =  ${id.value}
            </c:forEach>
         </c:if>
<br> <br>

<c:if  test="${!empty  studData}">
        student obj  data :  ${studData} <br>
        student obj  data :  ${studData.sno},${studData.sname},${studData.sadd},${studData.avg} <br>
        
</c:if>
<hr>
<c:choose>
   <c:when  test="${!empty studList}">
      <table border="1"  bgcolor="cyan">
         <tr>  <th> sno </th>  <th> sname </th>  <th> sadd </th>  <th> avg </th>    </tr>
         
         <c:forEach var="stud"  items="${studList}">
           <tr>
              <td>${stud.sno}</td>
              <td>${stud.sname}</td>
              <td>${stud.sadd}</td>
              <td>${stud.avg}</td>
           </tr>
         </c:forEach>
         
      </table>
   </c:when>
   <c:otherwise>
        <b>  No records found  </b>
   </c:otherwise>
</c:choose>





        
        
        
  
  
  


