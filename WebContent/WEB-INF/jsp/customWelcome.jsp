<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
<title>Custom Welcome</title>
</head>
<body>
<h2>A Special Welcome With Much Fanfare!</h2>
<a href="${contextPath}/reservationQuery">Court Reservation</a> <br>
Hurrah! Hurrah! The date today is <fmt:formatDate value="${today}" pattern="yyyy-MM-dd" />!
</body>	
</html>