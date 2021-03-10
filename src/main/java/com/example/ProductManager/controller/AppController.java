package com.example.ProductManager.controller;

import java.util.List;

import com.example.ProductManager.entity.Product;
import com.example.ProductManager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AppController {

    @GetMapping("/login")
    public  String login(){
        return "login";
    }

    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Product> listProduct = service.listAll();
        model.addAttribute("listProducts", listProduct);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product){
        service.save(product);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name="id") Long id){
        ModelAndView mav = new ModelAndView("edit_product");

        Product product = service.get(id);
        mav.addObject("product", product);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id){
        service.delete(id);

        return "redirect:/";
    }

}
