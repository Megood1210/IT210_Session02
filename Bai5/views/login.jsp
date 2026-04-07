<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head><title>Đăng nhập Portal</title></head>
<body>
<h2>Đăng nhập hệ thống nhân sự</h2>

<c:if test="${not empty errorMessage}">
    <p style="color:red"><c:out value="${errorMessage}"/></p>
</c:if>

<form action="<c:url value='/login'/>" method="post">
    Username: <input type="text" name="username"><br>
    Password: <input type="password" name="password"><br>
    <button type="submit">Đăng nhập</button>
</form>
</body>
</html>