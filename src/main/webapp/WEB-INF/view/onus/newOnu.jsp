<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Andriy
  Date: 9/10/2021
  Time: 7:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Onu</title>
</head>
<body>
<form:form action="/onus/createOnu" method="post" modelAttribute="onu">

    Onu SerialNumber <form:input  path="serialNumber" />
    <br><br>
    Onu ShortName <form:input path="shortName"/>
    <br><br>
    Onu BuildingId <form:input path="buildingId"/>
    <br><br>
    <input type="submit" value="Create Onu">

</form:form>
</body>
</html>
