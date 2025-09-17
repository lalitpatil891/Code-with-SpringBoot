<%@ page isELIgnored="false"  contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags"  prefix="sp" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

 <fmt:setLocale  value="${pageContext.response.locale}"/>
 
 <fmt:formatDate   var="fdate" value="${sysDate}"  type="date"  dateStyle="MEDIUM"/>
 <fmt:formatDate   var="ftime" value="${sysDate}"  type="time"  dateStyle="LONG"/>
 <fmt:formatDate   var="fdt" value="${sysDate}"  type="both"  dateStyle="LONG"/>
 


<h1  style="color:red;text-align:center"> <sp:message code="report.title"/> on  ${fdate} , ${ftime}-- ${fdt}</h1>

<c:choose>
  <c:when  test="${!empty listVO}">
  
  <table border="1" bgcolor="yellow" align="center"> 
    <tr  bgcolor="cyan">
      <th> <sp:message code="report.col.id"/></th>
      <th> <sp:message code="report.col.name"/></th>
      <th> <sp:message code="report.col.addrs"/> </th>
      <th> <sp:message code="report.col.category"/> </th>
      <th> <sp:message code="report.col.fee"/> </th>
      <th> <sp:message code="report.col.operations"/> </th>
    </tr>
     <c:forEach  var="vo" items="${listVO}">
       <tr>
         <td>${vo.aid}</td>
         <td>${vo.aname}</td>
         <td>${vo.addrs}</td>
         <td>${vo.category}</td>
          <%-- <fmt:formatNumber var="ffee"  value="${vo.fee}" type="number"/> --%>
          <fmt:formatNumber var="ffee"  value="${vo.fee}" type="currency"/>
         <td>${ffee}</td>
         <td> <a href="edit?no=${vo.aid}"><img src="images/edit.jpg" width="30" height="30">
                    &nbsp; &nbsp;&nbsp;&nbsp;
                    <a href="remove?no=${vo.aid}"  onclick="return confirm('<sp:message code="report.delete.confirm"/> ')"><img src="images/delete.jpg" width="30" height="30">
                    </a>  </td>
       </tr>
     </c:forEach>
 </table>
  </c:when>
  <c:otherwise>
               <h1  style="color:red;text-align:center"><sp:message code="report.data.notfound"/> </h1>
  </c:otherwise>
 </c:choose>
 <br> <h1 style="color:green;text-align:center;text-decoration:blink"> ${resultMsg} </h1> 
 <br><br>
 <h1  style="text-align:center"><a href="register"><img src="images/add.jpg" width="40" height="60"/> <sp:message code="report.add.link1"/></a></h1>
 
 <br><br>
 
 <h1  style="text-align:center"><a href="./"><img src="images/home.jpg"><sp:message code="report.home.link2"/></a></h1>
  
  <fmt:formatNumber var="favg"  value="${avg}"  type="percent"/>
  <b> Formated avg :: ${favg}</b>
 
 <center> <a href="?lang=es_ES">española</a> &nbsp; &nbsp; &nbsp;
                  <a href="?lang=hi_IN">हिंदी</a> &nbsp; &nbsp; &nbsp;
                  <a href="?lang=ko_KR">한국인 (korean)</a> &nbsp; &nbsp; &nbsp;
                  <a href="?lang=en_US">English</a> &nbsp; &nbsp; &nbsp;
   </center>