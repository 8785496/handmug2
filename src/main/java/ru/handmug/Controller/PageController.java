package ru.handmug.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.handmug.Form.ContactForm;

import javax.validation.Valid;

@Controller
public class PageController {
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(ContactForm contactForm) {
        return "contact";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String checkMessage(@Valid ContactForm contactForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "contact";
        }

        return "redirect:/";
    }
}
