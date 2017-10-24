package io.github.huherto.rbac.services;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class RealmAuthorityChecker {
    
    @SuppressWarnings("serial")
    public static class RealmGrantedAuthority implements GrantedAuthority {
        
        private String realm;
        
        private String role;

        public RealmGrantedAuthority(String realm, String role) {
            super();
            this.realm = realm;
            this.role = role;
        }

        @Override
        public String getAuthority() {
            return role;
        }

        public String getRealm() {
            return realm;
        }
        
    };
    
    public static boolean hasRoleInRealm(String realm, String role, Collection<? extends GrantedAuthority> authorities) {
    
        if (authorities == null) {
            return false;
        }
        
        for(GrantedAuthority auth : authorities) {
            
            if (auth instanceof RealmGrantedAuthority) {
                
                RealmGrantedAuthority rgAuth = (RealmGrantedAuthority) auth;
                if (auth.getAuthority() != null && auth.getAuthority().equals(role)) {
                    
                    if (rgAuth.getRealm() != null&& realm.startsWith(rgAuth.getRealm())) {
                        return true;
                    }
                    
                }
                
            }
            
        }
        
        return false;
        
    }
    
    public static boolean hasRoleInRealm(String role, String realm) {
        
        Collection<? extends GrantedAuthority> gaList = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        
        return hasRoleInRealm(role, realm, gaList);
    }
    
    

}
