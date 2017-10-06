package io.github.huherto.rbac.daos;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.github.huherto.rbac.daos.PermissionTable;

public class PermissionTableIT extends BaseTableIT {

    public PermissionTable table() {
        return database().permissionTable();
    }

    @Test
    public void testNotNull() {
        assertNotNull(table());
    }


}
