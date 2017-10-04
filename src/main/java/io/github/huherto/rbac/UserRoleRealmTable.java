package io.github.huherto.rbac;

import javax.sql.DataSource;

public class UserRoleRealmTable extends BaseUserRoleRealmTable {
    public UserRoleRealmTable(DataSource dataSource) {
        super(dataSource);
    }
}
