package hello.world.session2.Bai5.service;

import hello.world.session2.Bai5.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("NV001", "Nguyễn Thị Lan", "Kế toán", 15000000, "2020-03-01", "Đang làm"),
            new Employee("NV002", "Trần Văn Hùng", "Kỹ thuật", 25000000, "2019-07-15", "Đang làm"),
            new Employee("NV003", "Lê Minh Đức", "Kinh doanh", 18500000, "2021-11-20", "Nghỉ phép"),
            new Employee("NV004", "Phạm Thu Hương", "Kỹ thuật", 22000000, "2022-01-05", "Đang làm"),
            new Employee("NV005", "Hoàng Văn Nam", "Kế toán", 12000000, "2023-06-10", "Thử việc")
    ));

    public List<Employee> getAll() { return employees; }

    public Employee getByCode(String code) {
        return employees.stream().filter(e -> e.getCode().equals(code)).findFirst().orElse(null);
    }

    public double calculateTotalSalaryByDept(String dept) {
        return employees.stream()
                .filter(e -> e.getDepartment().equals(dept))
                .mapToDouble(Employee::getSalary).sum();
    }
}
