<h3>Chi tiết: <c:out value="${employee.fullName}"/></h3>
<ul>
    <li>Mã: ${employee.code}</li>
    <li>Lương:
        <c:choose>
            <c:when test="${sessionScope.role == 'hr_manager'}">
                <fmt:formatNumber value="${employee.salary}" type="currency" currencySymbol="VNĐ"/>
            </c:when>
            <c:otherwise>***</c:otherwise>
        </c:choose>
    </li>
</ul>