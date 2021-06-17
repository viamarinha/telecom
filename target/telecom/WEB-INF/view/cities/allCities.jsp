<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>AllCities</title>
</head>
<body>
<c:forEach var="city" items="${cities}">
    <a href="/cities/edit/${city.id}">${city.id}</a>
    Code  <c:out value="${city.code}"/>

    <p><custom:lineToBreakLine value="${fn:escapeXml(text)}" var="lineBreaks"/></p>
    ${lineBreaks}

</c:forEach>

<a href="/cities/createNewCity">Create New City</a>
<br>


</body>
</html>
