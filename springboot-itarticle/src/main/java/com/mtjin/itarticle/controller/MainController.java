package com.mtjin.itarticle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView goPage() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("views/main/index");
        return mv;
    }
}
