package ru.handmug.Service;

import org.springframework.stereotype.Service;
import ru.handmug.Entity.Category;
import ru.handmug.Entity.Picture;
import ru.handmug.Entity.Product;
import ru.handmug.Entity.ProductView;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DataService {
    private List<Category> categories;
    private List<Picture> pictures;
    private List<ProductView> productViews;

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

        productViews = new ArrayList<ProductView>() {{
            add(new ProductView(0, "Кружка \"Пингивин\"", "Кружка с аппликацией из полимерной глины", 300, 0, pictures.get(0)));
            add(new ProductView(1, "Кружка \"Сова в бантике\"", "Кружка с аппликацией из полимерной глины", 300, 0, pictures.get(0)));
            add(new ProductView(2, "Кружка \"Именная\"", "Кружка с аппликацией из полимерной глины", 300, 0, pictures.get(0)));
            add(new ProductView(3, "Кружка \"Пушистая овечка\"", "Кружка с аппликацией из полимерной глины", 300, 0, pictures.get(0)));
            add(new ProductView(4, "Сладкие кружки", "Кружка с аппликацией из полимерной глины", 300, 0, pictures.get(0)));
            add(new ProductView(10, "Шкатулка \"Мамины сокровища для мальчиков\"", "Чудесный набор для хранения самых дорогих вещей", 650, 1, pictures.get(0)));
        }};
    }

    public ProductView getProductById(int id) {
        for (ProductView productView : productViews) {
            if (productView.getId() == id) {
                return productView;
            }
        }

        return null;
    }

    public Picture getPictureById(int id) {
        for (Picture picture: pictures) {
            if (picture.getId() == id) {
                return picture;
            }
        }

        return null;
    }

    public List<ProductView> getProductsByCategoryId(int categoryId) {
        return productViews.stream().filter(product -> product.getCategoryId() == categoryId).collect(Collectors.toList());
    }

    public List<ProductView> getNewProducts() {
        List<ProductView> lastProductViews = new ArrayList<>();
        int count = 0;

        ListIterator<ProductView> li = productViews.listIterator(productViews.size());

        while (count < 5 && li.hasPrevious()) {
            lastProductViews.add(li.previous());
            count++;
        }

        return lastProductViews;
    }

    public List<ProductView> getAllProducts() {
        return productViews;
    }

    public Category getCategoryById(int id) {
        if (categories.size() > id) {
            return categories.get(id);
        }
        return null;
    }

    public List<ProductView> getProductsByCategoryId(int categoryId, int limit) {
        ListIterator<ProductView> li = productViews.listIterator(productViews.size());
        int count = 0;
        List<ProductView> listProductViews = new ArrayList<>();
        ProductView productView;

        while (count < limit && li.hasPrevious()) {
            productView = li.previous();
            if (productView.getCategoryId() == categoryId) {
                listProductViews.add(productView);
                count++;
            }
        }

        return listProductViews;
    }

    public void deleteProduct(int id) {
        Iterator<ProductView> iterator = productViews.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                return;
            }
        }
    }

    public boolean addProduct(Product product) {
        int id = (int) new Date().getTime();
        Picture picture = getPictureById(product.getPictureId());

        ProductView productView =  new ProductView(id, product.getName(), product.getDescription(), product.getPrice(), product.getCategoryId(), picture);

        return productViews.add(productView);
    }

    public void updateProduct(int id, Product product) {
        Picture picture = getPictureById(product.getPictureId());

        ProductView productView = getProductById(id);
        productView.setName(product.getName());
        productView.setDescription(product.getDescription());
        productView.setPrice(product.getPrice());
        productView.setCategoryId(product.getCategoryId());
        productView.setPicture(picture);
    }
}
