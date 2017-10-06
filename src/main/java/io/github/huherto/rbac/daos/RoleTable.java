package io.github.huherto.rbac.daos;

import javax.sql.DataSource;

public class RoleTable extends BaseRoleTable {
    public RoleTable(DataSource dataSource) {
        super(dataSource);
    }
}
