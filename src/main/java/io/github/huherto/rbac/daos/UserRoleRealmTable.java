package io.github.huherto.rbac.daos;

import javax.sql.DataSource;

public class UserRoleRealmTable extends BaseUserRoleRealmTable {
    public UserRoleRealmTable(DataSource dataSource) {
        super(dataSource);
    }
}
