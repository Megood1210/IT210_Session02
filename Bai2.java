package hello.world.session2;

//Phần 1
//| # | Vị trí                                   | Loại vấn đề                          | Mô tả hậu quả                                                                                                                                                                                   |
//| - | ---------------------------------------- | ------------------------------------ | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
//| 1 | `<%! private int requestCounter = 0; %>` | Race Condition / Thread Safety       | Biến này là **instance variable của Servlet (JSP compile ra Servlet)** → dùng chung cho tất cả user. Khi nhiều request đồng thời → giá trị bị sai, không chính xác, có thể gây lỗi concurrency. |
//| 2 | `<% requestCounter++; %>`                | Logic sai tầng (Business trong View) | View không nên xử lý logic như đếm request → vi phạm MVC (View chỉ hiển thị).                                                                                                                   |
//| 3 | `<% for (...) { ... } %>`                | Scriptlet trong JSP                  | Dùng Java code trong JSP làm code khó đọc, khó bảo trì → anti-pattern. Nên dùng JSTL `<c:forEach>`.                                                                                             |
//| 4 | `if (sv.getScore() >= ...)`              | Business Logic trong View            | Logic xếp loại nằm trong JSP → sai nguyên tắc MVC. Nên xử lý ở Controller hoặc Model.                                                                                                           |
//| 5 | `<%= sv.getFullName() %>`                | XSS (Cross-Site Scripting)           | Nếu tên chứa `<script>` → trình duyệt sẽ thực thi → cực kỳ nguy hiểm.                                                                                                                           |
//| 6 | `<%= sv.getScore()%>;`                   | Lỗi syntax                           | Dư dấu `;` → hiển thị sai (VD: `92;`) hoặc gây lỗi format.                                                                                                                                      |
//| 7 | `<%@ page import=... %>` + scriptlet     | Code coupling                        | JSP phụ thuộc trực tiếp Java class → giảm tính tách biệt giữa View và Model.                                                                                                                    |
//| 8 | HTML comment vs JSP                      | Comment không chuẩn                  | Nếu dùng `<!-- -->` cho logic nội bộ → vẫn render ra client → lộ thông tin. Nên dùng `<%-- --%>`.                                                                                               |

//Phần 2
//<%@ page contentType="text/html;charset=UTF-8" language="java" %>
//
//<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
//
//<html>
//<head>
//<title>Báo cáo điểm</title>
//</head>
//<body>
//
//<%-- Tiêu đề báo cáo --%>
//<h1>${reportTitle}</h1>
//
//<table border="1">
//    <tr>
//        <th>STT</th>
//<th>Họ tên</th>
//        <th>Điểm</th>
//<th>Xếp loại</th>
//    </tr>
//
//    <c:forEach var="sv" items="${studentList}" varStatus="loop">
//        <tr>
//<td>${loop.index + 1}</td>
//
//            <%-- chống XSS --%>
//            <td><c:out value="${sv.fullName}" /></td>
//
//        <td>${sv.score}</td>
//
//            <td>
//                <c:choose>
//                    <c:when test="${sv.score >= 90}">
//        Xuất sắc
//        </c:when>
//                    <c:when test="${sv.score >= 80}">
//        Giỏi
//        </c:when>
//                    <c:when test="${sv.score >= 70}">
//        Khá
//        </c:when>
//                    <c:when test="${sv.score >= 60}">
//        Trung bình khá
//                    </c:when>
//                    <c:when test="${sv.score >= 50}">
//        Trung bình
//        </c:when>
//            <c:otherwise>
//            Yếu
//            </c:otherwise>
//        </c:choose>
//            </td>
//        </tr>
//    </c:forEach>
//
//</table>
//
//</body>
//</html>