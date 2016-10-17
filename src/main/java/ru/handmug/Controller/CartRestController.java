package ru.handmug.Controller;

import org.springframework.context.annotation.Scope;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.handmug.Entity.CartItem;
import ru.handmug.Entity.Product;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Scope("session")
public class CartRestController {
    private List<CartItem> items;

    public CartRestController() {
        items = new ArrayList<CartItem>() {{
            CartItem item = new CartItem("Mug", 3);
            add(item);
            CartItem item2 = new CartItem("Box", 2);
            add(item2);
        }};
    }

    @RequestMapping(value = "/api/cart", method = RequestMethod.GET)
    public /*List<CartItem>*/ String cart(HttpSession httpSession) {
        Object attr = httpSession.getAttribute("attr");
        if (attr == null) {
            return "null";
        } else {
            return attr.toString();
        }
    }

    @RequestMapping(value = "/api/cartAdd", method = RequestMethod.POST)
    public CartItem cartAdd(@RequestBody CartItem cartItem, BindingResult bindingResult, HttpSession httpSession) {
        //bindingResult.hasErrors();

        httpSession.setAttribute("attr", "Hello");
        return cartItem;
    }


}



