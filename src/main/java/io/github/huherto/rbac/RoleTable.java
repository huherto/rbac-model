package io.github.huherto.rbac;

import javax.sql.DataSource;

public class RoleTable extends BaseRoleTable {
    public RoleTable(DataSource dataSource) {
        super(dataSource);
    }
}
