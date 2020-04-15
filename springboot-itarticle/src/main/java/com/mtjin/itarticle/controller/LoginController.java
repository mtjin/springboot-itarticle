package com.mtjin.itarticle.controller;

import com.mtjin.itarticle.UserDto;
import com.mtjin.itarticle.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView goLogin() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("views/login/login");
        return mv;
    }

    @RequestMapping(value = "/do_register", method = RequestMethod.POST)
    public ModelAndView doRegister(@ModelAttribute(name = "userDto")  UserDto userDto, HttpServletRequest request) {
        System.out.println(userDto.toString());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("views/login/register");
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

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public ModelAndView goReset() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("views/login/reset");
        return mv;
    }
}
