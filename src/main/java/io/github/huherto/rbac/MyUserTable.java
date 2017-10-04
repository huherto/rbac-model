package io.github.huherto.rbac;

import javax.sql.DataSource;

public class MyUserTable extends BaseMyUserTable {
    public MyUserTable(DataSource dataSource) {
        super(dataSource);
    }
}
