package com.gc.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CustomErrorController implements ErrorController
{	
//	@GetMapping("/")
//    public ModelAndView redirectWithUsingRedirectPrefix(ModelMap model) 
//	{
//        model.addAttribute("attribute", "redirectWithRedirectPrefix");
//        return new ModelAndView("login", model);
//    }
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomErrorController.class);
	
	@Override
	public String getErrorPath() {
		return "/error";
	}
	
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
    	String pageTitle = "Error";
    	String errorPage = "error";
    	
    	Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    	
    	if(status != null) {
    		Integer statusCode = Integer.valueOf(status.toString());
    		
    		if(statusCode == HttpStatus.NOT_FOUND.value()) {
    			pageTitle = "Page Not Found";
    			errorPage = "error/404";    			
    			LOGGER.error("Error 404");
    			
    			return "error/404";
    		}
    		
    		else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
    			return "error/500";
    		}
    		
    		else if(statusCode == HttpStatus.BAD_REQUEST.value()) {
    			return "error/400";
    		}
    		
    		else if(statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()) {
    			return "error/405";
    		}
    	}
    	
    	model.addAttribute("pageTitle", pageTitle);
    	
    	return errorPage;
    }
}
