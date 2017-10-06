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


}
