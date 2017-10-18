package io.github.huherto.rbac.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WithUserDetails("john")
@SpringBootTest(webEnvironment=WebEnvironment.NONE)
public class RbacServiceTest {

    @Autowired
    RbacService rbacService;

    @Test
    public void makeFakeData() {

        // rbacService.makeFakeData();

        SecurityContextHolderAwareRequestWrapper;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {

        }
    }
}
