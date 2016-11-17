package ru.handmug.Service;

import org.springframework.stereotype.Service;
import ru.handmug.Entity.Category;
import ru.handmug.Entity.Picture;
import ru.handmug.Entity.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

@Service
public class DataService {
    private List<Category> categories;
    private List<Picture> pictures;
    private  List<Product> products;

    public DataService() {
        pictures = new ArrayList<Picture>() {{
            add(new Picture(0, "Кружка Пушистая овечка", "mug_1_m.jpg", "mug_1_s.jpg"));
        }};

        categories = new ArrayList<Category>() {{
            add(new Category(0, "Кружки", "Изготовление декоративных кружек из полимерной глины, которые раскрасят даже самый пасмурный день, поднимут настроение и станут отличным подарком на любой праздник. Не упустите уникальную возможность сделать приятное своим близким, знакомым или просто порадовать себя. Стоимость от 300р! Декор выполнен из полимерной глины и приклеен на эпоксидный клей. Из кружечки можно пить, мыть её. Не рекомендуется мыть в посудомоечной машине и с абразивными средствами, не желательно нагревать саму кружку в микроволновке."));
            add(new Category(1, "Шкатулки", "Красивый способ сохранить воспоминания. Коробочка «Мамины сокровища»! В коробку можно поместить то количество маленьких коробочек, которое подойдет именно Вам! Например, \"бирочка\", \"пустышка\", \"зубик\", \"тест\" (ведь именно с него начинается приятное ожидание чуда!), \"локон\", носочки и т.д. \n" +
                    "Коробочка выполнена из пивного и переплетного картона, обтянута тканью, украшена бусинами , цветами, стразами!.\n" +
                    "Возможно изготовление с другим количеством маленьких коробочек. Работа выполнена полностью вручную «с нуля»."));
            add(new Category(2, "Игрушки из цветов", ""));
        }};

        products = new ArrayList<Product>() {{
            add(new Product(0, "Кружка \"Пингивин\"", "Кружка с аппликацией из полимерной глины", 300, 0, pictures.get(0)));
            add(new Product(1, "Кружка \"Сова в бантике\"", "Кружка с аппликацией из полимерной глины", 300, 0, pictures.get(0)));
            add(new Product(2, "Кружка \"Именная\"", "Кружка с аппликацией из полимерной глины", 300, 0, pictures.get(0)));
            add(new Product(3, "Кружка \"Пушистая овечка\"", "Кружка с аппликацией из полимерной глины", 300, 0, pictures.get(0)));
            add(new Product(4, "Сладкие кружки", "Кружка с аппликацией из полимерной глины", 300, 0, pictures.get(0)));
            add(new Product(10, "Шкатулка \"Мамины сокровища для мальчиков\"", "Чудесный набор для хранения самых дорогих вещей", 650, 1, pictures.get(0)));
        }};
    }

    public Product getProductById(int id) {
        for (Product product: products) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    public List<Product> getProductsByCategoryId(int categoryId) {
        return products.stream().filter(product -> product.getCategoryId() == categoryId).collect(Collectors.toList());
    }

    public List<Product> getNewProducts() {
        List<Product> lastProducts = new ArrayList<>();
        int count = 0;

        ListIterator<Product> li = products.listIterator(products.size());

        while (count < 5 && li.hasPrevious()) {
            lastProducts.add(li.previous());
            count++;
        }

        return lastProducts;
    }

    public Category getCategoryById(int id) {
        if (categories.size() > id) {
            return categories.get(id);
        }
        return null;
    }

    public List<Product> getProductsByCategoryId(int categoryId, int limit) {
        ListIterator<Product> li = products.listIterator(products.size());
        int count = 0;
        List<Product> listProducts = new ArrayList<>();
        Product product;

        while (count < limit && li.hasPrevious()) {
            product = li.previous();
            if (product.getCategoryId() == categoryId) {
                listProducts.add(product);
                count++;
            }
        }

        return listProducts;
    }

    public void deleteProduct(int id) {
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                return;
            }
        }
    }
}
