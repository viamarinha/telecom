<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Region</title>
</head>
<body>
<form:form method="post" action="/regions/new" modelAttribute="region">

    Code_of_Region <form:input path="code"/>
    <br> <br>
    Short_Name <form:input path="shortName"/>
    <br><br>
    City_Id <form:input path="cityId"/>
    <br><br>

    <input type="submit" value="Submit new region">

</form:form>
</body>
</html>
