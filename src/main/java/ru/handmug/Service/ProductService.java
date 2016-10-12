package ru.handmug.Service;

import org.springframework.stereotype.Service;
import ru.handmug.Entity.Category;
import ru.handmug.Entity.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    public List<Product> getProducts(){
        Category category1 = new Category();

        return new ArrayList<Product>(){{
            add(new Product("Кружка", "Кружка", 300.0f, category1));
            add(new Product("Шкатулка", "Кружка", 300.0f, category1));
        }};
    }
}
