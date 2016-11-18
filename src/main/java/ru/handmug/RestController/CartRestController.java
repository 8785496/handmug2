package ru.handmug.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.handmug.Entity.Cart;
import ru.handmug.Entity.CartItem;
import ru.handmug.Entity.ProductView;
import ru.handmug.Service.DataService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
//@Scope("session")
public class CartRestController {
//    private List<CartItem> items;
    @Autowired
    private DataService dataService;

//    public CartRestController() {
//        items = new ArrayList<CartItem>() {{
//            CartItem item = new CartItem("Mug", 3);
//            add(item);
//            CartItem item2 = new CartItem("Box", 2);
//            add(item2);
//        }};
//    }

    @RequestMapping(value = "/api/cart", method = RequestMethod.GET)
    public List<CartItem> cart(HttpSession httpSession) {
        Cart cart = (Cart) httpSession.getAttribute("cart");

        if (cart == null) {
            return new ArrayList<>();
        } else {
            return cart.getCartItems();
        }
    }

    @RequestMapping(value = "/api/cart/add", method = RequestMethod.POST)
    public Cart cartAdd(@RequestBody CartItem cartItem, BindingResult bindingResult, HttpSession httpSession) {
        //bindingResult.hasErrors();
        Cart cart = (Cart) httpSession.getAttribute("cart");
        ProductView productView = dataService.getProductById(cartItem.getProductId());

        if (cart == null) {
            cart = new Cart();
        }

        cart.addItem(cartItem, productView.getPrice());

        httpSession.setAttribute("cart", cart);
        return cart;
    }

    @RequestMapping(value = "/api/cart/remove", method = RequestMethod.POST)
    public Cart cartRemove(HttpSession httpSession) {
        httpSession.removeAttribute("cart");

        return new Cart();
    }

    @RequestMapping(value = "/api/cart/remove/:id", method = RequestMethod.POST)
    public Cart cartRemoveItem(HttpSession httpSession) {
//        Cart cart = (Cart) httpSession.getAttribute("cart");
//        if (cart == null) {
//            cart = new Cart();
//        }
//
//
//
//        return new Cart();
        return null;
    }
}



