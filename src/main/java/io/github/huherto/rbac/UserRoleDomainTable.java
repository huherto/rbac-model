package io.github.huherto.rbac;

import javax.sql.DataSource;

public class UserRoleDomainTable extends BaseUserRoleDomainTable {
    public UserRoleDomainTable(DataSource dataSource) {
        super(dataSource);
    }
}
