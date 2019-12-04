package com.aulaspring2.controller;

import com.aulaspring2.model.Cliente;
import com.aulaspring2.service.ClienteService;
import com.aulaspring2.service.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService service;
    @Autowired
    private TelefoneService serviceTelefone;

    @GetMapping("/cliente")
    public ModelAndView findAllCliente() {

        ModelAndView mv = new ModelAndView("/postCliente");
        mv.addObject("posts", service.findAllCliente());

        return mv;
    }

    @GetMapping("/cliente/add")
    public ModelAndView addCliente(Cliente local) {

        ModelAndView mv = new ModelAndView("/postAddCliente");
        mv.addObject("post", local);
        mv.addObject("telefones", serviceTelefone.findAllTelefone());

        return mv;
    }

    @GetMapping("/cliente/edit/{id}")
    public ModelAndView editCliente(@PathVariable("id") Long id) {

        return addCliente(service.findOneCliente(id));
    }

    @GetMapping("/cliente/delete/{id}")
    public ModelAndView deleteCliente(@PathVariable("id") Long id) {

        service.deleteCliente(id);

        return findAllCliente();
    }

    @PostMapping("/cliente/save")
    public ModelAndView saveCliente(@Valid Cliente local, BindingResult result) {

        if(result.hasErrors()) {
            return addCliente(local);
        }

        service.inserirCliente(local);

        return findAllCliente();
    }
}