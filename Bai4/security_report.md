1. XSS (Cross-Site Scripting) là lỗ hổng cho phép attacker chèn mã JavaScript vào trang web, khiến trình duyệt 
người dùng thực thi mã độc.
<c:out value="${keyword}"/> an toàn hơn ${keyword} trong trường hợp này vì nếu dùng ${keyword} thì trình duyệt 
sẽ thực thi JS
2. | Tiêu chí    | `<c:if>`    | `<c:choose>`         |
   | ----------- |-------------| -------------------- |
   | Logic       | 1 điều kiện | nhiều nhánh (if-else)|
   | Tương đương | if          | switch / if-else-if  |
   | Có else     | có          |  (`<c:otherwise>`)   |
Trong bài này, phần hiển thị “Giá vé” và “Vé còn lại” nên dùng loại <c:choose> vì <c:if> khó đọc, dễ chạy nhiều
điều kiện cùng lúc
3. So với hardcode href="/events/1/book <c:url> giải quyết vấn đề tự động thêm context path. Khi ứng dụng được deploy với 
context path /ticketing thay vì / thì sẽ bị sai đường dẫn.