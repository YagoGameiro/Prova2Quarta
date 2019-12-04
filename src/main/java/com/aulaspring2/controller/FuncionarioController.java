package com.aulaspring2.controller;

import com.aulaspring2.model.Funcionario;
import com.aulaspring2.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping("/funcionario")
    public ModelAndView findAllFuncionario() {

        ModelAndView mv = new ModelAndView("/post");
        mv.addObject("posts", service.findAll());

        return mv;
    }

    @GetMapping("/funcionario/add")
    public ModelAndView addFuncionario(Funcionario local) {

        ModelAndView mv = new ModelAndView("/postAdd");
        mv.addObject("post", local);

        return mv;
    }

    @GetMapping("/funcionario/edit/{id}")
    public ModelAndView editFuncionario(@PathVariable("id") Long id) {

        return addFuncionario(service.findOne(id));
    }

    @GetMapping("/funcionario/delete/{id}")
    public ModelAndView deleteFuncionario(@PathVariable("id") Long id) {

        service.delete(id);

        return findAllFuncionario();
    }

    @PostMapping("/funcionario/save")
    public ModelAndView saveFuncionario(@Valid Funcionario local, BindingResult result) {

        if(result.hasErrors()) {
            return addFuncionario(local);
        }

        service.inserir(local);

        return findAllFuncionario();
    }
}
