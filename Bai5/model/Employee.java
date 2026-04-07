package hello.world.session2.Bai5.model;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Employee {
    private String code;
    private String fullName;
    private String department;
    private double salary;
    private Date hiredDate;
    private String status;

    public Employee() {
    }

    public Employee(String code, String fullName, String department, double salary, String dateStr, String status) {
        this.code = code;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.status = status;
        try {
            this.hiredDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (Exception e) { this.hiredDate = new Date(); }
    }


    public String getCode() { return code; }
    public String getFullName() { return fullName; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public Date getHiredDate() { return hiredDate; }
    public String getStatus() { return status; }
}