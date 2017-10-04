package io.github.huherto.rbac;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class UserRoleDomainTableIT extends BaseTableIT {

    public UserRoleDomainTable table() {
        return database().userRoleDomainTable();
    }

    @Test
    public void testNotNull() {
        assertNotNull(table());
    }


}
