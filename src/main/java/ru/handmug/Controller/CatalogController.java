package ru.handmug.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.handmug.Entity.Product;
import ru.handmug.Service.ProductService;

import java.util.List;

@Controller
public class CatalogController {
    @Autowired
    ProductService productService;


    @RequestMapping("/")
    public String index(Model model){

//        List<Product> products = productService.getProducts();
//        model.addAttribute("products", products);
        return "index";
    }

}
