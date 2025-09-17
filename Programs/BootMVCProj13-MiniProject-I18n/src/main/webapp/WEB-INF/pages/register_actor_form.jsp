<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="sp"%>

<h1  style="color:red;text-align:center"> <sp:message  code="register.title"/> </h1>

<frm:form action="register"  method="POST" modelAttribute="actor">
  <table   bgcolor="cyan"  align="center">
     <tr>
       <th> <sp:message  code="register.label1"/> </th>
       <th>  <frm:input type="text"  path="aname"/> </th>
     </tr>
     <tr>
       <th> <sp:message  code="register.label2"/> </th>
       <th>  <frm:input type="text"  path="addrs"/> </th>
     </tr>
     <tr>
       <th> <sp:message  code="register.label3"/> </th>
       <th>  <frm:input type="text"  path="category"/> </th>
     </tr>
     <tr>
       <th> <sp:message  code="register.label4"/> </th>
       <th>  <frm:input type="text"  path="fee"/> </th>
     </tr>
     <tr>
        <th> <input type="submit"  value="<sp:message  code="register.submit"/>"> </th>
        <th> <input type="reset"  value="cancel"> </th>
     </tr>
     </table>

</frm:form> <br>
 <center> <a href="?lang=es_ES&no=${actor.aid}">española</a> &nbsp; &nbsp; &nbsp;
                  <a href="?lang=hi_IN&no=${actor.aid}">हिंदी</a> &nbsp; &nbsp; &nbsp;
                  <a href="?lang=ko_KR&no=${actor.aid}">한국인 (korean)</a> &nbsp; &nbsp; &nbsp;
                  <a href="?lang=en_US&no=${actor.aid}">English</a> &nbsp; &nbsp; &nbsp;
   </center>