package io.github.huherto.rbac.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.github.huherto.rbac.daos.UserRoleRealmRecord;
import io.github.huherto.rbac.services.RbacService;
import io.github.huherto.rbac.util.StringUtils;

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

    boolean usersInitialized = true; // TODO: Remove

    @GetMapping("/users")
    public String users(Model model) {

        if (!usersInitialized) {
            rbacService.makeFakeData();
            usersInitialized = true;
        }

        model.addAttribute("users", rbacService.getAllUsers() );

        return "users";
    }

    @GetMapping("/user-roles")
    public String userRoles(@RequestParam Integer userId, Model model) {

        model.addAttribute("userRoles", rbacService.getAllRolesForUser(userId) );
        model.addAttribute("user", rbacService.getUser(userId) );
        model.addAttribute("allroles", rbacService.getAllRoles());

        return "user-roles";
    }
    
    @PostMapping("/delete-user-role")
    public String deleteUserRole(@RequestParam Integer userRoleRealmId, Model model) {

        logger.debug("start deleteUserRole(userRoleRealmId="+userRoleRealmId+")");
        
        UserRoleRealmRecord userRoleRealm = rbacService.deleteUserRole(userRoleRealmId);

        return userRoles(userRoleRealm.getUserId(), model);
    }

    @PostMapping("/new-user-role")
    public String newUserRole(@RequestParam Integer userId, @RequestParam String realmField, @RequestParam Integer roleId, Model model) {

        logger.debug("start newUserRole("+realmField+","+roleId+")");
        
        UserRoleRealmRecord userRoleRealm = rbacService.addNewRole(userId, realmField, roleId );

        return userRoles(userId, model);
    }
    
}

