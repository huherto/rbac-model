package io.github.huherto.rbac;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class MyUserTableIT extends BaseTableIT {

    public MyUserTable table() {
        return database().myUserTable();
    }

    @Test
    public void testNotNull() {
        assertNotNull(table());
    }


}
