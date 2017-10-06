package io.github.huherto.rbac.daos;

import javax.sql.DataSource;

public class PermissionTable extends BasePermissionTable {
    public PermissionTable(DataSource dataSource) {
        super(dataSource);
    }
}
