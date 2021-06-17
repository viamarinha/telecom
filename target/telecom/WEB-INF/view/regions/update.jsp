<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
    <form:form method="PATCH" action="/regions/update/${region.id}/cityId/${region.city.id}" modelAttribute="region">

        Code <form:input path="code"/>
        <br><br>
        ShortName <form:input path="shortName"/>
        <br><br>
        City <form:input path="city"/>
        <br><br>
        <input type="submit" value="Edit Region">

    </form:form>
</body>
</html>
