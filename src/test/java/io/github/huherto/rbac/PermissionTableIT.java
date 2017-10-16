package io.github.huherto.rbac;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class PermissionTableIT extends BaseTableIT {

    public PermissionTable table() {
        return database().permissionTable();
    }

    @Test
    public void testNotNull() {
        assertNotNull(table());
    }


}
