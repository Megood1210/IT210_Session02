# Phân tích Scope và Race Condition

## 1. Tại sao lỗi đăng nhập dùng Request Scope?

Thông báo lỗi chỉ cần hiển thị **1 lần sau khi submit form**.

* Request Scope:

    * Tồn tại trong 1 request → đúng nhu cầu
    * Không bị lưu lâu

Nếu dùng Session:

* Lỗi sẽ bị "dính" lại
* Người dùng đăng nhập đúng vẫn thấy lỗi cũ
* Gây UX rất tệ

---

## 2. Tại sao totalViewCount dùng Application Scope?

Application Scope:

* Dùng chung cho toàn bộ hệ thống
* Mọi user đều thấy cùng 1 giá trị

Nếu dùng Session:

* Mỗi user có 1 bản riêng
* Ví dụ:

    * User A thấy: 5
    * User B thấy: 2
      → Không phản ánh tổng hệ thống

---

## 3. Race Condition là gì?

Race Condition xảy ra khi:

* Nhiều thread truy cập & sửa cùng 1 biến
* Kết quả phụ thuộc thứ tự thực thi

### Code lỗi:

```java
Integer count = (Integer) application.getAttribute("totalViewCount");
if (count == null) count = 0;
count++;
application.setAttribute("totalViewCount", count);
```

### Vấn đề:

2 request cùng lúc:

* Cả 2 cùng đọc count = 10
* Cả 2 tăng lên 11
  → Kết quả sai (phải là 12)

---

## 4. Cách khắc phục

### Cách 1: synchronized

```java
synchronized (application) {
    Integer count = (Integer) application.getAttribute("totalViewCount");
    if (count == null) count = 0;
    count++;
    application.setAttribute("totalViewCount", count);
}
```

### Cách 2: AtomicInteger

```java
AtomicInteger count = (AtomicInteger) application.getAttribute("totalViewCount");
if (count == null) {
    count = new AtomicInteger(0);
    application.setAttribute("totalViewCount", count);
}
count.incrementAndGet();
```

→ Thread-safe, hiệu năng tốt hơn synchronized
