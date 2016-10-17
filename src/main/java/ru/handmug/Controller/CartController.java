package ru.handmug.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CartController {
    @RequestMapping("/cart")
    public String cart(HttpSession httpSession) {
        return "cart";
    }
}
