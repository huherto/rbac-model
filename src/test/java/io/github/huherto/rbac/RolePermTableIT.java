package io.github.huherto.rbac;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class RolePermTableIT extends BaseTableIT {

    public RolePermTable table() {
        return database().rolePermTable();
    }

    @Test
    public void testNotNull() {
        assertNotNull(table());
    }


}
