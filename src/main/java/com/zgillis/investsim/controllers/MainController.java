package com.zgillis.investsim.controllers;

import com.zgillis.investsim.services.PropertiesConfigLoader;
import com.zgillis.investsim.util.RendererAssistant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;


@RestController
public class MainController {

    @Autowired
    RendererAssistant ra;

    @Autowired
    PropertiesConfigLoader propertiesConfigLoader;

    @GetMapping({"/", "/index"})
    public ModelAndView homePage(Model orig) {
        ModelAndView mav = new ModelAndView();
        orig.addAttribute("title", propertiesConfigLoader.getSiteName());
        orig.addAttribute("description", "Allows you to simulate trading.");
        orig.addAttribute("currentts", LocalDateTime.now().toString());
        mav.setViewName("index");
        return mav;
    }

}
