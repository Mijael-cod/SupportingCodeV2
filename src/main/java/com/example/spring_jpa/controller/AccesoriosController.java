package com.example.spring_jpa.controller;

import com.example.spring_jpa.entity.Accesorios;
import com.example.spring_jpa.servicios.AccesoriosService;
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

/**
 *
 * @author mijae
 */

@Controller
@RequestMapping("/acc")
public class AccesoriosController {
    
    @Autowired
    private AccesoriosService accesoriosService;
    
    @GetMapping("/all")
    public String listarAcc(Model model){
        model.addAttribute("accesorios", accesoriosService.readAll());
        return "cate/listarAcc";
    }
    
    @GetMapping("/form")
    public String createAcc(Model model){
        model.addAttribute("titulo", "Registrar Accesorios");
        model.addAttribute("accesorios", new Accesorios());
        return "cate/formAcc";
    }
    
    @PostMapping("/add")
    public String saveAcc(@Valid @ModelAttribute Accesorios acc, BindingResult result, Model model, RedirectAttributes attributes){
        accesoriosService.create(acc);
        //model.addAttribute("categorias", categoriaService.readAll());
        return "redirect:/acc/all";
    }
    
    @GetMapping("/del/{id}")
    public String deleteAcc(Model model, @PathVariable("id") Integer idacc ){
        accesoriosService.delete(idacc);
        return "redirect:/acc/all";
    }
    
    @GetMapping("/edit/{id}")
    public String editAcc(Model model, @PathVariable("id") Integer idacc ){
        Accesorios accesorios = accesoriosService.read(idacc);
        model.addAttribute("titulo", "Modificar Accesorios");
        model.addAttribute("accesorios", accesorios);
        return "cate/formAcc";
    }
    
    
}
