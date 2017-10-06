package io.github.huherto.rbac.daos;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.github.huherto.rbac.daos.RolePermTable;

public class RolePermTableIT extends BaseTableIT {

    public RolePermTable table() {
        return database().rolePermTable();
    }

    @Test
    public void testNotNull() {
        assertNotNull(table());
    }


}
