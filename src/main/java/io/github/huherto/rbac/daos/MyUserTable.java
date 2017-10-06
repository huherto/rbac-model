package io.github.huherto.rbac.daos;

import javax.sql.DataSource;

public class MyUserTable extends BaseMyUserTable {
    public MyUserTable(DataSource dataSource) {
        super(dataSource);
    }
}
