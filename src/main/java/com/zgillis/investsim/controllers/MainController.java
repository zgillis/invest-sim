package com.zgillis.investsim.controllers;

import com.zgillis.investsim.util.RendererAssistant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class MainController {

    @Autowired
    RendererAssistant ra;

    // TODO: Remove
    @RequestMapping("/errorz")
    public ModelAndView handlePoo(Model orig) {
        ModelAndView mav = new ModelAndView();
        orig.addAttribute("testwurd", "Testing 123");
        mav.setViewName("errorz");
        return mav;
    }

}
