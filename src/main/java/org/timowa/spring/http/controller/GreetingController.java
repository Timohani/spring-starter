package org.timowa.spring.http.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView hello(ModelAndView mv) {
        mv.setViewName("greeting/hello");
        return mv;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView bye(ModelAndView mv) {
        mv.setViewName("greeting/bye");
        return mv;
    }
}
