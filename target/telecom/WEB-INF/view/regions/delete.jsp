<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Andriy
  Date: 6/17/2021
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="DELETE" action="/regions/deleteRegion/${region.id}" modelAttribute="region">
    Delete region with id <form:input path="id"/>
    <br>
    <input type="submit" value="Delete region">

</form:form>

</body>
</html>
