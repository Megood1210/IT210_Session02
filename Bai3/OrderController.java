package hello.world.session2.Bai3;


import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class OrderController {

    @GetMapping("/orders")
    public String showOrders(HttpSession session,
                             Model model,
                             ServletContext application) {

        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        List<Order> orders = new ArrayList<>();
        orders.add(new Order("OD01", "Laptop", 15000000, new Date()));
        orders.add(new Order("OD02", "Chuột", 200000, new Date()));
        orders.add(new Order("OD03", "Bàn phím", 500000, new Date()));

        model.addAttribute("orderList", orders);

        synchronized (application) {
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if (count == null) count = 0;
            count++;
            application.setAttribute("totalViewCount", count);
        }

        return "orders";
    }
}