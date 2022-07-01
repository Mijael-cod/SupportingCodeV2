package com.example.spring_jpa.controller;

import com.example.spring_jpa.entity.Producto;
import com.example.spring_jpa.servicios.ProductoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/prod")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/all")
    public String listarProd(Model model){
        //String keyword = "Yogurt";
        model.addAttribute("productos", productoService.readAll());
        return "cate/listarProd";
    }
    
    @GetMapping("/form")
    public String createProd(Model model){
        model.addAttribute("titulo", "Registrar Producto");
        model.addAttribute("producto", new Producto());
        return "cate/formProd";
    }
    
    @PostMapping("/add")
    public String saveProd(@Valid @ModelAttribute Producto prod, BindingResult result, Model model, RedirectAttributes attributes){
        productoService.create(prod);
        //model.addAttribute("categorias", categoriaService.readAll());
        return "redirect:/prod/all";
    }
    
    @GetMapping("/del/{id}")
    public String deleteProd(Model model, @PathVariable("id") Integer idprod ){
        productoService.delete(idprod);
        return "redirect:/prod/all";
    }
    
    @GetMapping("/edit/{id}")
    public String editProd(Model model, @PathVariable("id") Integer idcat ){
        Producto producto = productoService.read(idcat);
        model.addAttribute("titulo", "Modificar Producto");
        model.addAttribute("producto", producto);
        return "cate/formProd";
    }
    
    @PostMapping("/{id}")
    public String readProd(Model model, @PathVariable("id") Integer idprod ){
        model.addAttribute("prod", productoService.read(idprod));
        return "redirect:/prod";
    }
}
