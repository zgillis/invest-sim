package com.zgillis.investsim.controllers;

import com.zgillis.investsim.util.RendererAssistant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class MainController {

    @Autowired
    RendererAssistant ra;

    @RequestMapping("/errorz")
    public ModelAndView handlePoo() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("errorz");
        return mav;
    }

}
