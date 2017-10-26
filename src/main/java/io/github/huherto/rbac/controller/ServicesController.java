package io.github.huherto.rbac.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.huherto.rbac.daos.UserRoleRealmRecord;
import io.github.huherto.rbac.services.RbacService;

@RestController
public class ServicesController {

    private static final Log logger = LogFactory.getLog(UserInterfaceController.class);

    @Autowired
    RbacService rbacService;

    @PostMapping("/delete-user-role")
    public String deleteUserRole(@RequestParam Integer userRoleRealmId, Model model) {

        logger.debug("start deleteUserRole(userRoleRealmId="+userRoleRealmId+")");
        
        UserRoleRealmRecord userRoleRealm = rbacService.deleteUserRole(userRoleRealmId);

        return "OK";
    }

    @PostMapping("/new-user-role")
    public String newUserRole(@RequestParam Integer userId, @RequestParam String realmField, @RequestParam Integer roleId, Model model) {

        logger.debug("start newUserRole("+realmField+","+roleId+")");
        
        UserRoleRealmRecord userRoleRealm = rbacService.addNewRole(userId, realmField, roleId );

        return "OK";
    }    
    
}
