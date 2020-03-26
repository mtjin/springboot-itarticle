package com.mtjin.itarticle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView goLogin() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("views/login/login");
        return mv;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView goRegister() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("views/login/register");
        return mv;
    }

    @RequestMapping(value = "/forgot", method = RequestMethod.GET)
    public ModelAndView goForgot() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("views/login/forgot");
        return mv;
    }
}
