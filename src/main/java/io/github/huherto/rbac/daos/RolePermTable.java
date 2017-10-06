package io.github.huherto.rbac.daos;

import javax.sql.DataSource;

public class RolePermTable extends BaseRolePermTable {
    public RolePermTable(DataSource dataSource) {
        super(dataSource);
    }
}
