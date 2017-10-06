package io.github.huherto.rbac.daos;

import javax.sql.DataSource;

public class RBACDatabase extends BaseDatabase {

    public RBACDatabase(DataSource dataSource) {
        super(dataSource);
    }
}
