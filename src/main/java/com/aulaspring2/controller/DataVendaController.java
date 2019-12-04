package com.aulaspring2.controller;

import com.aulaspring2.model.DataVenda;
import com.aulaspring2.service.DataVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class DataVendaController {

    @Autowired
    private DataVendaService service;

    @GetMapping("/dataVenda")
    public ModelAndView findAllDataVenda() {

        ModelAndView mv = new ModelAndView("/postDataVenda");
        mv.addObject("posts", service.findAllDataVenda());

        return mv;
    }

    @GetMapping("/dataVenda/add")
    public ModelAndView addDataVenda(DataVenda dataVenda) {

        ModelAndView mv = new ModelAndView("/postAddDataVenda");
        mv.addObject("post", dataVenda);

        return mv;
    }

    @GetMapping("/dataVenda/edit/{id}")
    public ModelAndView editDataVenda(@PathVariable("id") Long id) {

        return addDataVenda(service.findOneDataVenda(id));
    }

    @GetMapping("/dataVenda/delete/{id}")
    public ModelAndView deleteDataVenda(@PathVariable("id") Long id) {

        service.deleteDataVenda(id);

        return findAllDataVenda();
    }

    @PostMapping("/dataVenda/save")
    public ModelAndView saveVenda(@Valid DataVenda local, BindingResult result) {

        if(result.hasErrors()) {
            return addDataVenda(local);
        }

        service.inserirDataVenda(local);

        return findAllDataVenda();
    }
}
