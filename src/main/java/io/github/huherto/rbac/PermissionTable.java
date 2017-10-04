package io.github.huherto.rbac;

import javax.sql.DataSource;

public class PermissionTable extends BasePermissionTable {
    public PermissionTable(DataSource dataSource) {
        super(dataSource);
    }
}
