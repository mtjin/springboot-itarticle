    package com.mtjin.itarticle.controller;

    import com.mtjin.itarticle.UserDto;
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

        @RequestMapping(value = "/login", method = RequestMethod.GET)
        public ModelAndView goLogin( HttpServletRequest request) {

            ModelAndView mv = new ModelAndView();
            mv.setViewName("views/login/login");
            return mv;
        }

        //Map 형태 ResponseBody 어노테이션 필요 객체 Body로 받아야함
        @ResponseBody
        @RequestMapping(value = "/do_register", method = RequestMethod.POST)
        public Map<String, String> doRegister(@ModelAttribute(name = "userDto") UserDto userDto) {
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

        @ResponseBody
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
