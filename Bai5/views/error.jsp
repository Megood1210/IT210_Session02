<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head><title>Lỗi hệ thống</title></head>
<body>
<h1 style="color:red">Đã có lỗi xảy ra</h1>
<p>Thông báo lỗi: <b><c:out value="${errorMessage}"/></b></p>
<a href="<c:url value='/employees'/>">Quay lại danh sách</a>
</body>
</html>