package com.aulaspring2.controller;

import com.aulaspring2.model.Telefone;
import com.aulaspring2.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class TelefoneController {

    @Autowired
    private TelefoneService service;

    @GetMapping("/telefone")
    public ModelAndView findAllTelefone() {

        ModelAndView mv = new ModelAndView("/postTelefone");
        mv.addObject("posts", service.findAllTelefone());

        return mv;
    }

    @GetMapping("/telefone/add")
    public ModelAndView addTelefone(Telefone telefone) {

        ModelAndView mv = new ModelAndView("/postAddTelefone");
        mv.addObject("post", telefone);

        return mv;
    }

    @GetMapping("/telefone/edit/{id}")
    public ModelAndView editTelefone(@PathVariable("id") Long id) {

        return addTelefone(service.findOneTelefone(id));
    }

    @GetMapping("/telefone/delete/{id}")
    public ModelAndView deleteTelefone(@PathVariable("id") Long id) {

        service.deleteTelefone(id);

        return findAllTelefone();
    }

    @PostMapping("/telefone/save")
    public ModelAndView saveVenda(@Valid Telefone local, BindingResult result) {

        if(result.hasErrors()) {
            return addTelefone(local);
        }

        service.inserirTelefone(local);

        return findAllTelefone();
    }
}
