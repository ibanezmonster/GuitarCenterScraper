package com.gc.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gc.model.search.Instrument;
import com.gc.model.search.InstrumentDto;
import com.gc.model.search.InstrumentSearch;
import com.gc.model.selection.InstrumentSelection;
import com.gc.requestPull.RequestPull;
import com.gc.scripting.ScraperScriptRunner;

@Controller
@RequestMapping("/")
public class TemplateController {

	@GetMapping("login")
    //@GetMapping({"login", "/"})
    public String getLogin() {	
        return "login";
    }
	
	@PostMapping("logout")
	public String getLogout(){//HttpServletRequest request, HttpServletResponse response) {
//	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	    if (auth != null){    
//	        new SecurityContextLogoutHandler().logout(request, response, auth);
//	    }
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
    	
    	//make one method that starts the whole process of reading from file and then retrieving data into list
    	//InstrumentSearch searchProcess = new InstrumentSearch(instrumentSelection.getInstrumentSelection());
    	//Optional<List<String>> instrumentList = searchProcess.getList();  	    	
    	
    	//model.addAttribute("searchResults", instrumentList);

    	
    	//testing serialized file
    	
    	//testing file path
//    	try(var fis = new BufferedInputStream(new FileInputStream("../../../../../../saved/Acoustic Guitar.txt")))
//		{
//    		var buffer = new byte[1024];
//			String text = fis.read(buffer);
//		}
//		catch (IOException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    	
    	
    	
    	
    	
    	try
    	{
    		String data = "";

    		data = new String(Files.readAllBytes(Paths.get("saved/Acoustic Guitar.ser")));
    		//data = new String(Files.readAllBytes(Paths.get("testAcoustic Guitar.txt")));
    		
    		System.out.println(data);
    	}
    	
		catch (Exception e)
		{
			e.printStackTrace();
		}
    	
        return "home";
    }
    
    
    @PostMapping("newpull")
    public String getRequestPull(Model model, InstrumentSelection instrumentSelection) 
    {
    	//List<Instrument> instrumentList = new ArrayList<>();
    	    	
    	//run instrument search scraper, which outputs to JSON file
    	ScraperScriptRunner.execute(instrumentSelection);
    	    	
    	//check if pull is successful
    	    	    	
    	//if successful, read from JSON file then write to serialized file
    	
    	//RequestPull pull = new RequestPull();    	    	
    	//pull.write(instrumentSelection);
    	
    	
    	
    	
    	//pull.write(instrumentSelection, instrumentList);
    	
		model.addAttribute("instrumentSelectionForm", new InstrumentSelection());
    	    	    	  
    	return "home";
    }
    
  
    @GetMapping("about")
    public String getAbout(Model model) {   
    	
		model.addAttribute("instrumentSelectionForm", new InstrumentSelection());
    	
        return "home";
    }
}
