package ru.handmug.RestController;

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

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    DataService dataService;



}
