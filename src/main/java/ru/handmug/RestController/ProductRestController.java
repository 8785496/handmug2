package ru.handmug.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.handmug.Entity.Product;
import ru.handmug.Entity.ProductView;
import ru.handmug.Service.DataService;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/api/products", method = RequestMethod.GET)
    public List<ProductView> getProducts() {
        return dataService.getAllProducts();
    }

    @RequestMapping(value = "/api/product/{id}", method = RequestMethod.GET)
    public ProductView getProduct(@PathVariable int id) {
        return dataService.getProductById(id);
    }

    @RequestMapping(value = "/api/product/{id}", method = RequestMethod.DELETE)
    public List<ProductView> deleteProduct(@PathVariable int id) {
        dataService.deleteProduct(id);

        return dataService.getAllProducts();
    }

    @RequestMapping(value = "/api/product/{id}", method = RequestMethod.PUT)
    public ProductView deleteProduct(@PathVariable int id, @RequestBody Product product) {
        dataService.updateProduct(id, product);

        return dataService.getProductById(id);
    }

    @RequestMapping(value = "/api/products", method = RequestMethod.POST)
    public List<ProductView> addProduct(@RequestBody Product product) {
        if (dataService.addProduct(product)) {
            return dataService.getAllProducts();
        } else {
            return null;
        }
    }
}
