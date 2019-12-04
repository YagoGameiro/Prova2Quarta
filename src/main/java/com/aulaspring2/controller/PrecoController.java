package com.aulaspring2.controller;

import com.aulaspring2.model.Preco;
import com.aulaspring2.service.PrecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PrecoController {

    @Autowired
    private PrecoService service;

    @GetMapping("/preco")
    public ModelAndView findAllPreco() {

        ModelAndView mv = new ModelAndView("/post");
        mv.addObject("posts", service.findAllPreco());

        return mv;
    }

    @GetMapping("/preco/add")
    public ModelAndView addPreco(Preco local) {

        ModelAndView mv = new ModelAndView("/postAdd");
        mv.addObject("post", local);

        return mv;
    }

    @GetMapping("/preco/edit/{id}")
    public ModelAndView editPreco(@PathVariable("id") Long id) {

        return addPreco(service.findOnePreco(id));
    }

    @GetMapping("/preco/delete/{id}")
    public ModelAndView deletePreco(@PathVariable("id") Long id) {

        service.deletePreco(id);

        return findAllPreco();
    }

    @PostMapping("/preco/save")
    public ModelAndView savePreco(@Valid Preco local, BindingResult result) {

        if(result.hasErrors()) {
            return addPreco(local);
        }

        service.inserirPreco(local);

        return findAllPreco();
    }
}
