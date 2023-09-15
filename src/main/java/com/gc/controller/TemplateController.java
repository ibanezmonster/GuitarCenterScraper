package com.gc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gc.model.selection.InstrumentSelection;

@Controller
@RequestMapping("/")
public class TemplateController {

	@GetMapping("login")
    //@GetMapping({"login", "/"})
    public String getLogin() {	
        return "login";
    }
	
	@GetMapping("logout")
	public String getLogout(HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
		return "login";
	}
	
	@GetMapping("register")
    public String getRegister() {	
        return "register";
    }
 
    @GetMapping("home")
    public String getHome(Model model) {  	
 	
    	//populate selection list
    	//List<String> instrumentSelectionCategoryList = InstrumentSelection.getListEntries();    
    	    	
		model.addAttribute("instrumentSelectionForm", new InstrumentSelection());
    	
        return "home";
    }
    
    @PostMapping("search")
    public String getSearch(Model model, InstrumentSelection instrumentSelection) {

		model.addAttribute("instrumentSelectionForm", new InstrumentSelection());
    	model.addAttribute("instrumentSelectionModel", instrumentSelection);
    		
        return "home";
    }
    
  
    @GetMapping("about")
    public String getAbout(Model model) {    	    	
    	
        return "about";
    }
  
}
