package io.github.huherto.rbac.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.huherto.rbac.daos.MyUserRecord;
import io.github.huherto.rbac.daos.RbacDatabase;
import io.github.huherto.rbac.daos.RoleRecord;
import io.github.huherto.rbac.daos.UserRoleRealmRecord;
import io.github.huherto.rbac.daos.UserRoleRealmTable.UserRoleNameRealm;

@Service
public class RbacService {

    private static final Log logger = LogFactory.getLog(RbacService.class);
    
    @Autowired
    protected RbacDatabase rbacDatabase;

    public List<MyUserRecord> getAllUsers() {
        return rbacDatabase.myUserTable().queryAll();
    }

    @PostConstruct
    public void makeFakeData() {

        logger.debug("making fake data");
        
        rbacDatabase.myUserTable().makeFakeData();

        rbacDatabase.roleTable().makeFakeData();

        RoleRecord role = rbacDatabase.roleTable().queryAll().get(0);

        for(MyUserRecord user : rbacDatabase.myUserTable().queryAll()) {
            rbacDatabase.userRoleRealmTable().makeFakeData(user, role);
        }
    }

    public List<UserRoleNameRealm> getAllRolesForUser(int userId) {
        return rbacDatabase.userRoleRealmTable().findRoleWithNameByUserId(userId);
    }

    public UserRoleRealmRecord deleteUserRole(Integer userRoleRealmId) {
        
        UserRoleRealmRecord userRoleRealm = rbacDatabase.userRoleRealmTable().findByPK(userRoleRealmId).get();
        
        logger.info("delete userRoleRealId="+userRoleRealmId);
        
        rbacDatabase.userRoleRealmTable().deleteByPK(userRoleRealmId);
        
        return userRoleRealm;
        
    }
}
