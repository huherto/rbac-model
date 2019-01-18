package io.github.huherto.rbac.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import io.github.huherto.rbac.daos.MyUserRecord;
import io.github.huherto.rbac.daos.MyUserTableIT;
import io.github.huherto.rbac.daos.RbacDatabase;
import io.github.huherto.rbac.daos.RoleRecord;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.NONE)
public class RbacServiceTest {

    @Autowired
    RbacService rbacService;
    
    private static final Log logger = LogFactory.getLog(RbacServiceTest.class);    
    
    @Autowired
    protected RbacDatabase rbacDatabase;    
    
    @Before
    public void makeFakeData() {

        logger.debug("making fake data");
        
        MyUserTableIT.makeFakeData(rbacDatabase.myUserTable());

        rbacDatabase.roleTable().makeFakeData();

        RoleRecord role = rbacDatabase.roleTable().queryAll().get(0);

        for(MyUserRecord user : rbacDatabase.myUserTable().queryAll()) {
            rbacDatabase.userRoleRealmTable().makeFakeData(user, role);
        }
    }

    @Test
    @WithUserDetails("john")
    public void makeFakeDataTest() {

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication a = context.getAuthentication();
        if (a != null) {
            Collection<? extends GrantedAuthority> auths = a.getAuthorities();
            
            assertTrue(a.getPrincipal() instanceof UserDetails );
            UserDetails user = (UserDetails) a.getPrincipal();
            assertEquals("john", user.getUsername());
            
        }
        
    }
}
