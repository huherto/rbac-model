package io.github.huherto.rbac.daos;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.github.huherto.rbac.daos.RoleTable;

public class RoleTableIT extends BaseTableIT {

    public RoleTable table() {
        return database().roleTable();
    }

    @Test
    public void testNotNull() {
        assertNotNull(table());
    }


}
