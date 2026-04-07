<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<header style="background: #f4f4f4; padding: 10px; border-bottom: 1px solid #ccc;">
    <strong>Portal Nhân sự</strong> |
    Xin chào, <c:out value="${sessionScope.loggedUser}"/> (<c:out value="${sessionScope.role}"/>)
    <nav>
        <a href="<c:url value='/employees'/>">Danh sách NV</a> |
        <c:if test="${sessionScope.role == 'hr_manager'}">
            <a href="#">Báo cáo quản trị</a> |
        </c:if>
        <a href="<c:url value='/logout'/>">Đăng xuất</a>
    </nav>
</header>