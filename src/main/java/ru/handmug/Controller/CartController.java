package ru.handmug.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.handmug.Entity.CartItem;
import ru.handmug.Entity.Product;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CartController {
    private List<CartItem> items;

    public CartController() {
        items = new ArrayList<CartItem>() {{
            CartItem item = new CartItem("Mug", 3);
            add(item);
            CartItem item2 = new CartItem("Box", 2);
            add(item2);
        }};
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public /*List<CartItem>*/ String cart(HttpSession httpSession) {
        Object attr = httpSession.getAttribute("attr");
        if (attr == null) {
            return "null";
        } else {
            return attr.toString();
        }
    }

    @RequestMapping(value = "/cartAdd", method = RequestMethod.POST)
    public CartItem cartAdd(@RequestBody CartItem cartItem, BindingResult bindingResult, HttpSession httpSession) {
        //bindingResult.hasErrors();

        httpSession.setAttribute("attr", "Hello");
        return cartItem;
    }
}



