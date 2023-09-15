package com.gc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class RedirectController
{	
	@GetMapping("/")
    public ModelAndView redirectWithUsingRedirectPrefix(ModelMap model) 
	{
        model.addAttribute("attribute", "redirectWithRedirectPrefix");
        return new ModelAndView("login", model);
    }
}
