<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<html>
<head><title>Danh sách nhân viên</title></head>
<body>
<%@ include file="common/header.jsp" %>
<h2>Danh sách nhân viên</h2>
<table border="1">
    <tr>
        <th>STT</th><th>Họ tên</th><th>Phòng ban</th><th>Lương</th><th>Ngày vào</th><th>Trạng thái</th><th>Thao tác</th>
    </tr>
    <c:forEach items="${employees}" var="emp" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td><c:out value="${emp.fullName}"/></td>
            <td><c:out value="${emp.department}"/></td>
            <td><fmt:formatNumber value="${emp.salary}" type="currency" currencySymbol="VNĐ"/></td>
            <td><fmt:formatDate value="${emp.hiredDate}" pattern="dd/MM/yyyy"/></td>
            <td>
                <c:choose>
                    <c:when test="${emp.status == 'Đang làm'}"><span style="color:green">${emp.status}</span></c:when>
                    <c:when test="${emp.status == 'Nghỉ phép'}"><span style="color:orange">${emp.status}</span></c:when>
                    <c:otherwise><span style="color:blue">${emp.status}</span></c:otherwise>
                </c:choose>
            </td>
            <td><a href="<c:url value='/employees/${emp.code}'/>">Xem chi tiết</a></td>
        </tr>
    </c:forEach>
</table>
<p><b>Tổng lương phòng Kỹ thuật: </b><fmt:formatNumber value="${techTotalSalary}" type="currency" currencySymbol="VNĐ"/></p>
<%@ include file="common/footer.jsp" %>
</body>
</html>