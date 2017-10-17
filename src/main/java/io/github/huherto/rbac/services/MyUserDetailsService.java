package io.github.huherto.rbac.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.github.huherto.rbac.daos.MyUserRecord;
import io.github.huherto.rbac.daos.RbacDatabase;
import io.github.huherto.rbac.daos.UserRoleRealmTable.UserRoleNameRealm;

@Service
public class MyUserDetailsService implements UserDetailsService {
    
    private static final Log logger = LogFactory.getLog(MyUserDetailsService.class);
    
    @Autowired
    protected RbacDatabase rbacDatabase;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        logger.debug("finding user:"+username);
        
        MyUserRecord myuser = rbacDatabase.myUserTable().findByLoginName(username).orElseThrow( () -> new UsernameNotFoundException("Nel: "+username) );
        
        List<UserRoleNameRealm> roles = rbacDatabase.userRoleRealmTable().findRoleWithNameByUserId(myuser.getUserId());
        
        Set<GrantedAuthority> gaSet = new HashSet<>();
        for(UserRoleNameRealm role : roles) {
            SimpleGrantedAuthority ga = new SimpleGrantedAuthority(role.roleName);
            gaSet.add(ga);
        }
        
        User userDetails = new User(myuser.getLoginName(), myuser.getPasswordValue(), gaSet);
                
        return userDetails;
    }

}
