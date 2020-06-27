package com.mtjin.itarticle.controller;

import com.mtjin.itarticle.UserDto;
import com.mtjin.itarticle.domain.entity.UserEntity;
import com.mtjin.itarticle.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@AllArgsConstructor
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String goLogin(HttpServletRequest request) {
        return "views/login/login";
    }

    @PostMapping("/do_login")
    public @ResponseBody Map<String, String> doLogin(@ModelAttribute(name = "userDto") UserDto userDto) {
        Map<String, String> map = new HashMap<>();
        try {
            UserEntity user = userService.login(userDto);
            if (user == null) {
                map.put("success", "false");
            } else {
                map.put("success", "true");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    //Map 형태 ResponseBody 어노테이션 필요 객체 Body로 받아야함
    @PostMapping("/do_register")
    public @ResponseBody Map<String, String> doRegister(@ModelAttribute(name = "userDto") UserDto userDto) {
        System.out.println(userDto.toString());
        Map<String, String> map = new HashMap<>();
        try {
            map.put("email", "true");
            map.put("name", "true");
            if (userService.isExistEmail(userDto)) {
                map.put("email", "false");
                map.put("success", "false");
            } else if (userService.isExistName(userDto)) {
                map.put("name", "false");
                map.put("success", "false");
            } else {
                userService.saveUser(userDto);
                map.put("success", "true");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @GetMapping(value = "/register")
    public String goRegister() {
        return "views/login/register";
    }

    @GetMapping("/forgot")
    public String goForgot() {
        return "views/login/forgot";
    }

    @GetMapping("/reset")
    public String goReset() {
        return "views/login/reset";
    }
}
