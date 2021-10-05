<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Andriy
  Date: 9/10/2021
  Time: 8:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Onu</title>
</head>
<body>
<form:form method="PATCH" action="/onus/update/${onu.id}" modelAttribute="onu">

    SerialNumber <form:input path="serialNumber"/>
    <br>
    ShortName <form:input path="shortName"/>
    <br>
    BuildingId <form:input path="buildingId"/>

    <input type="submit" value="Update Onu">


</form:form>
</body>
</html>
