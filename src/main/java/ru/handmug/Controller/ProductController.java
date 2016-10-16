package ru.handmug.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.handmug.Entity.Product;
import ru.handmug.Service.DataService;
import ru.handmug.Service.ProductService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    DataService dataService;


    @RequestMapping("/product/{id}")
    public String index(@PathVariable int id, Model model){
        Product product = dataService.getProductById(id);
        model.addAttribute("product", product);

        return "single";
    }
}
