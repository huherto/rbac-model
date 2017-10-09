package io.github.huherto.rbac.daos;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository
public class RbacDatabase extends BaseDatabase {

    public RbacDatabase(DataSource dataSource) {
        super(dataSource);
    }
}
