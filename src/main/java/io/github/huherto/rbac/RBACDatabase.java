package io.github.huherto.rbac;

import javax.sql.DataSource;

public class RBACDatabase extends BaseDatabase {

    public RBACDatabase(DataSource dataSource) {
        super(dataSource);
    }
}
