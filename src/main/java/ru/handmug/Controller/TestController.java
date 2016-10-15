package ru.handmug.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.handmug.Entity.Product;
import ru.handmug.Service.MailService;
import ru.handmug.Service.ProductService;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    private MailService mailService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/testmail")
    public String testMail() {
        try {
            mailService.sendEmail();
        } catch (MailException e) {
            return e.getMessage();
        }

        return "Сообщение отправлено";
    }

    @RequestMapping("/testCategory")
    public List<Product> testCategory() {
        return productService.getProductsByCategoryId(1);
    }
}
