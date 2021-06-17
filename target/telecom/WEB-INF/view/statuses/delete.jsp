<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>


<form:form method="DELETE" action="/status/delete/${status.id}" modelAttribute="status">

  Id Status to be deleted  <form:input path="id"/>
    <input type="submit" value="Delete"/>


</form:form>
</body>
</html>
