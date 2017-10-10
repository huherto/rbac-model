package io.github.huherto.rbac.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.huherto.rbac.daos.MyUserRecord;
import io.github.huherto.rbac.daos.RbacDatabase;

@Service
public class RbacService {

    @Autowired
    private RbacDatabase rbacDatabase;

    public List<MyUserRecord> getAllUsers() {
        return rbacDatabase.myUserTable().queryAll();
    }

    public void makeFakeData() {
        
        rbacDatabase.myUserTable().makeFakeData();
        
    }


}
