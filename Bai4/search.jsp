<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<html>
<head>
    <title>Kết quả tìm kiếm</title>
</head>
<body>

<!-- A. HEADER -->
<h2>
    Kết quả tìm kiếm cho:
    <c:out value="${keyword}" />
</h2>

<p>Tìm thấy ${fn:length(events)} sự kiện</p>

<c:if test="${empty events}">
    <p style="color:red;">Không tìm thấy sự kiện nào phù hợp.</p>
</c:if>

<!-- B. TABLE -->
<c:if test="${not empty events}">
    <table border="1">
        <tr>
            <th>STT</th>
            <th>Tên sự kiện</th>
            <th>Ngày tổ chức</th>
            <th>Giá vé</th>
            <th>Vé còn lại</th>
            <th>Thao tác</th>
        </tr>

        <c:forEach var="event" items="${events}" varStatus="status">
            <tr>
                <!-- STT -->
                <td>${status.count}</td>

                <!-- Tên (XSS safe) -->
                <td>
                    <c:out value="${event.name}" />
                </td>

                <!-- Ngày -->
                <td>${event.date}</td>

                <!-- Giá vé -->
                <td>
                    <c:choose>
                        <c:when test="${event.price == 0}">
                            <span style="color:green;">MIỄN PHÍ</span>
                        </c:when>
                        <c:otherwise>
                            <fmt:formatNumber value="${event.price}" type="number"/>
                        </c:otherwise>
                    </c:choose>
                </td>

                <!-- Vé còn lại -->
                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <span style="color:red;">HẾT VÉ</span>
                        </c:when>

                        <c:when test="${event.remainingTickets < 10}">
                            <span style="color:orange;">
                                Sắp hết (còn ${event.remainingTickets} vé)
                            </span>
                        </c:when>

                        <c:otherwise>
                            <span style="color:green;">
                                    ${event.remainingTickets}
                            </span>
                        </c:otherwise>
                    </c:choose>
                </td>

                <!-- Thao tác -->
                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <span style="color:gray;">Đặt vé</span>
                        </c:when>
                        <c:otherwise>
                            <a href="<c:url value='/events/${event.id}/book'/>">
                                Đặt vé
                            </a>
                        </c:otherwise>
                    </c:choose>
                </td>

            </tr>
        </c:forEach>
    </table>
</c:if>

<!-- C. FOOTER -->
<c:if test="${not empty events}">
    <p>
        Sự kiện đầu tiên:
            ${fn:toUpperCase(events[0].name)}
    </p>
</c:if>

<p>
    Độ dài từ khóa:
    ${fn:length(keyword)} ký tự
</p>

</body>
</html>