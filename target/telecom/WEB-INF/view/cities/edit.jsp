<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditCity</title>
</head>
<body>
<form:form method="patch" action="/cities/update/${city.id}" modelAttribute="city">

  City Code   <form:input path="code"/>

    <p><custom:lineToBreakLine value="${fn:escapeXml(text)}" var="lineBreaks"/></p>
    ${lineBreaks}

    <input type="submit" value="Update">

</form:form>
<br><br>
<a href="/cities/deleteCity/${city.id}">Delete City</a>

</body>
</html>
