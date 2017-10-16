package io.github.huherto.rbac.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.huherto.rbac.daos.MyUserRecord;
import io.github.huherto.rbac.daos.RbacDatabase;
import io.github.huherto.rbac.daos.RoleRecord;
import io.github.huherto.rbac.daos.UserRoleRealmRecord;

@Service
public class RbacService {

    @Autowired
    protected RbacDatabase rbacDatabase;

    public List<MyUserRecord> getAllUsers() {
        return rbacDatabase.myUserTable().queryAll();
    }

    public void makeFakeData() {

        rbacDatabase.myUserTable().makeFakeData();

        rbacDatabase.roleTable().makeFakeData();

        RoleRecord role = rbacDatabase.roleTable().queryAll().get(0);

        for(MyUserRecord user : rbacDatabase.myUserTable().queryAll()) {
            rbacDatabase.userRoleRealmTable().makeFakeData(user, role);
        }
    }

    public List<UserRoleRealmRecord> getAllRolesForUser(int userId) {
        return rbacDatabase.userRoleRealmTable().findByUserId(userId);
    }
}
