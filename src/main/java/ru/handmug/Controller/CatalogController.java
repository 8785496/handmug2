package ru.handmug.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.handmug.Entity.Cart;
import ru.handmug.Entity.Category;
import ru.handmug.Entity.ProductView;
import ru.handmug.Service.DataService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CatalogController {
    @Autowired
    DataService dataService;


    @RequestMapping("/")
    public String index(Model model){

        List<ProductView> productViews = dataService.getNewProducts();
        model.addAttribute("products", productViews);
        return "index";
    }

    @RequestMapping("/category/{id}")
    public String category(@PathVariable int id, Model model) {
        Category category = dataService.getCategoryById(id);

        if (category == null) {
            return "404";
        }

        model.addAttribute("category", category);

        List<ProductView> productViews = dataService.getProductsByCategoryId(id);
        model.addAttribute("products", productViews);

        return "products";
    }

    @RequestMapping("/product/{id}")
    public String index(@PathVariable int id, Model model){
        ProductView productView = dataService.getProductById(id);
        model.addAttribute("product", productView);

        List<ProductView> productViews = dataService.getProductsByCategoryId(productView.getCategoryId(), 3);
        model.addAttribute("products", productViews);

        return "single";
    }

    @RequestMapping("/cart")
    public String cart(HttpSession httpSession, Model model) {
        Cart cart = (Cart)httpSession.getAttribute("cart");
        if (cart != null) {
            model.addAttribute(cart);
        } else {
            model.addAttribute(new Cart());
        }
        return "cart";
    }

    @RequestMapping("/categories")
    public String categories() {
        return "categories";
    }
}
