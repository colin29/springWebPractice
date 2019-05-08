<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
<title>Main page</title>
</head>
<body>
<h2>Main page</h2>
<a href="${contextPath}/reservationQuery">Court Reservation</a> <br>
</body>
</html>