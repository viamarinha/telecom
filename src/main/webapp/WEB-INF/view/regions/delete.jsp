<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="DELETE" action="/regions/deleteRegion/${region.id}" modelAttribute="region">
    Delete Region with id <form:input path="id"/>

    <p><custom:lineToBreakLine value="${fn:escapeXml(text)}" var="lineBreaks"/></p>
    ${lineBreaks}
    <input type="submit" value="Delete Region">
</form:form>
</body>
</html>
