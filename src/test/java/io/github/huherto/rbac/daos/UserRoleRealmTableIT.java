package io.github.huherto.rbac.daos;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.github.huherto.rbac.daos.UserRoleRealmTable;

public class UserRoleRealmTableIT extends BaseTableIT {

    public UserRoleRealmTable table() {
        return database().userRoleRealmTable();
    }

    @Test
    public void testNotNull() {
        assertNotNull(table());
    }

    @Test
    public void testQueryRoleName() {
        
        database().myUserTable().makeFakeData();
        database().roleTable().makeFakeData();

        RoleRecord role = database().roleTable().queryAll().get(0);

        for(MyUserRecord user : database().myUserTable().queryAll()) {
            database().userRoleRealmTable().makeFakeData(user, role);
        }
        MyUserRecord user = database().myUserTable().queryAll().get(0);
        
        table().findRoleWithNameByUserId(user.getUserId());
        
    }
}
