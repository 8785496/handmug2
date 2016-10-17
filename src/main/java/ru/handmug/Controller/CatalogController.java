package ru.handmug.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.handmug.Entity.Product;
import ru.handmug.Service.DataService;

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
        List<Product> products = dataService.getProductsByCategoryId(id);
        model.addAttribute("products", products);

        return "products";
    }
}
