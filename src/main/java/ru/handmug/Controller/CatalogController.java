package ru.handmug.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.handmug.Entity.Category;
import ru.handmug.Entity.Product;
import ru.handmug.Service.DataService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CatalogController {
    @Autowired
    DataService dataService;


    @RequestMapping("/")
    public String index(Model model){

        List<Product> products = dataService.getNewProducts();
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping("/category/{id}")
    public String category(@PathVariable int id, Model model) {
        Category category = dataService.getCategoryById(id);

        if (category == null) {
            return "404";
        }

        model.addAttribute("category", category);

        List<Product> products = dataService.getProductsByCategoryId(id);
        model.addAttribute("products", products);

        return "products";
    }

    @RequestMapping("/product/{id}")
    public String index(@PathVariable int id, Model model){
        Product product = dataService.getProductById(id);
        model.addAttribute("product", product);

        List<Product> products = dataService.getProductsByCategoryId(product.getCategoryId(), 3);
        model.addAttribute("products", products);

        return "single";
    }

    @RequestMapping("/cart")
    public String cart(HttpSession httpSession) {
        return "cart";
    }

    @RequestMapping("/categories")
    public String categories() {
        return "categories";
    }
}
