package io.github.huherto.rbac.daos;

import javax.sql.DataSource;

public class RbacDatabase extends BaseDatabase {

    public RbacDatabase(DataSource dataSource) {
        super(dataSource);
    }
}
