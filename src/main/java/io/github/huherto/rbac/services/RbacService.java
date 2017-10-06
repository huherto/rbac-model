package io.github.huherto.rbac.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.huherto.rbac.daos.MyUserRecord;
import io.github.huherto.rbac.daos.RBACDatabase;

@Service
public class RbacService {
    
    @Autowired
    private RBACDatabase rbacDatabase;
        
    public List<MyUserRecord> getAllUsers() {        
        return rbacDatabase.myUserTable().queryAll();        
    }
    
    
}
