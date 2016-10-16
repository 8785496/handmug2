package ru.handmug.Service;

import org.springframework.stereotype.Service;
import ru.handmug.Entity.Category;
import ru.handmug.Entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
//    List<Product> products;
//
//    public ProductService() {
//        products = new ArrayList<Product>() {{
//            add(new Product(0, "Кружка \"Пингивин\"", "Кружка с аппликацией из полимерной глины", 300.0f, 0));
//            add(new Product(1, "Кружка \"Сова в бантике\"", "Кружка с аппликацией из полимерной глины", 300.0f, 0));
//            add(new Product(2, "Кружка \"Именная\"", "Кружка с аппликацией из полимерной глины", 300.0f, 0));
//            add(new Product(3, "Кружка \"Пушистая овечка\"", "Кружка с аппликацией из полимерной глины", 300.0f, 0));
//            add(new Product(4, "Сладкие кружки", "Кружка с аппликацией из полимерной глины", 300.0f, 0));
//            add(new Product(10, "Шкатулка \"Мамины сокровища для мальчиков\"", "Чудесный набор для хранения самых дорогих вещей", 650.0f, 1));
//        }};
//    }
//
//    public List<Product> getProducts(){
//        return products;
//    }
//
//    public Product getProductById(int id) {
//        for (Product product: products) {
//            if (product.getId() == id) {
//                return product;
//            }
//        }
//
//        return null;
//    }
//
//    public List<Product> getProductsByCategoryId(int categoryId) {
//        return products.stream().filter(product -> product.getCategoryId() == categoryId).collect(Collectors.toList());
//    }
}
