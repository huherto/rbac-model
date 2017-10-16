package io.github.huherto.rbac;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class UserRoleRealmTableIT extends BaseTableIT {

    public UserRoleRealmTable table() {
        return database().userRoleRealmTable();
    }

    @Test
    public void testNotNull() {
        assertNotNull(table());
    }


}
