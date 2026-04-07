package hello.world.session2.Bai5.controller;

import hello.world.session2.Bai5.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String list(HttpSession session, Model model) {
        if (session.getAttribute("loggedUser") == null) return "redirect:/login";

        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("techTotalSalary", employeeService.calculateTotalSalaryByDept("Kỹ thuật"));
        return "list";
    }

    @GetMapping("/{code}")
    public String detail(@PathVariable String code, HttpSession session, Model model) {
        if (session.getAttribute("loggedUser") == null) return "redirect:/login";

        var emp = employeeService.getByCode(code);
        if (emp == null) throw new RuntimeException("Nhân viên [" + code + "] không tồn tại trong hệ thống");

        model.addAttribute("employee", emp);
        return "detail";
    }
}
