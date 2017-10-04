package io.github.huherto.rbac;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class RoleTableIT extends BaseTableIT {

    public RoleTable table() {
        return database().roleTable();
    }

    @Test
    public void testNotNull() {
        assertNotNull(table());
    }


}
