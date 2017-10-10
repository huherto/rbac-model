package io.github.huherto.rbac.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.huherto.rbac.services.RbacService;

@Controller
public class RbacController {

	private static final Log logger = LogFactory.getLog(RbacController.class);

	
	@Autowired
	RbacService rbacService;

	@InitBinder
	public void initBinder( WebDataBinder binder ) {
	   binder.initDirectFieldAccess();
	}

    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @RequestMapping("/login")
    public String login(Model model) {
    	logger.debug("set view name to login."+model);
    	return "login";
    }

    @GetMapping("/actors")
    public String actors(Model model) {
        return "actors";
    }

    
    boolean usersInitialized = false;
    
    @GetMapping("/users")
    public String users(Model model) {
        
        if (!usersInitialized) {            
            rbacService.makeFakeData();
            usersInitialized = true;
        }
        
        model.addAttribute("users", rbacService.getAllUsers() );
        
        return "users";
    }
}

