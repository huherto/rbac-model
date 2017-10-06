package io.github.huherto.rbac.daos;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.github.huherto.rbac.daos.MyUserTable;

public class MyUserTableIT extends BaseTableIT {

    public MyUserTable table() {
        return database().myUserTable();
    }

    @Test
    public void testNotNull() {
        assertNotNull(table());
    }


}
