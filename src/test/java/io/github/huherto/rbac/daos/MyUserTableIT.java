package io.github.huherto.rbac.daos;

import static org.junit.Assert.assertEquals;
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

    @Test
    public void testFakeData() {

        table().makeFakeData();

        assertEquals(1, table().queryAll().size());

    }


}
