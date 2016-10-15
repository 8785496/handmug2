package ru.handmug.Service;

import org.springframework.stereotype.Service;
import ru.handmug.Entity.Category;
import ru.handmug.Entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    List<Product> products;

    public ProductService() {
        products = new ArrayList<Product>() {{
            add(new Product(0, "Кружка \"Пингивин\"", "Кружка с аппликацией из полимерной глины", 300.0f, 0));
            add(new Product(10, "Шкатулка \"Мамины сокровища для мальчиков\"", "Чудесный набор для хранения самых дорогих вещей", 650.0f, 1));
        }};
    }

    public List<Product> getProducts(){
        return products;
    }

    public Product getProductById(int id) {
        return products.get(id);
    }

    public List<Product> getProductsByCategoryId(int categoryId) {
        return products.stream().filter(product -> product.getCategoryId() == categoryId).collect(Collectors.toList());
    }
}
