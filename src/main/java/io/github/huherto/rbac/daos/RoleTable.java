package io.github.huherto.rbac.daos;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class RoleTable extends BaseRoleTable {
    public RoleTable(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected SimpleJdbcInsert buildInsert() {
        return super.buildInsert("ROLE_ID");
    }

    public void makeFakeData() {

        RoleRecord nr = new RoleRecord();
        nr.setRoleName("AUTH_ADMIN");
        this.insert(nr);

        nr = new RoleRecord();
        nr.setRoleName("AUTH_USER");
        this.insert(nr);
        
    }
}
