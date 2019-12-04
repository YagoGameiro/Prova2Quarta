package com.aulaspring2.controller;

import com.aulaspring2.model.Venda;
import com.aulaspring2.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class VendaController {

    @Autowired
    private VendaService service;

    @GetMapping("/venda")
    public ModelAndView findAllVenda() {

        ModelAndView mv = new ModelAndView("/post");
        mv.addObject("posts", service.findAllVenda());

        return mv;
    }

    @GetMapping("/venda/add")
    public ModelAndView addVenda(Venda local) {

        ModelAndView mv = new ModelAndView("/postAdd");
        mv.addObject("post", local);

        return mv;
    }

    @GetMapping("/venda/edit/{id}")
    public ModelAndView editVenda(@PathVariable("id") Long id) {

        return addVenda(service.findOneVenda(id));
    }

    @GetMapping("/venda/delete/{id}")
    public ModelAndView deleteVenda(@PathVariable("id") Long id) {

        service.deleteVenda(id);

        return findAllVenda();
    }

    @PostMapping("/venda/save")
    public ModelAndView saveVenda(@Valid Venda local, BindingResult result) {

        if(result.hasErrors()) {
            return addVenda(local);
        }

        service.inserirVenda(local);

        return findAllVenda();
    }
}
