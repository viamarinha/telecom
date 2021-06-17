<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Statuses</title>
</head>
<body>


<c:forEach items="${status}" var="status">
    Status Id <a href="/status/edit/${status.id}">${status.id}</a>
    Active <c:out value="${status.active}"/>
    Functional <c:out value="${status.functional}"/>
    In service <c:out value="${status.inService}"/>

    <p><custom:lineToBreakLine value="${fn:escapeXml(text)}" var="lineBreaks"/></p>
    ${lineBreaks}
</c:forEach>

<a href="/status/createStatus">Create a new Status</a>
<br><br>
</body>
</html>
