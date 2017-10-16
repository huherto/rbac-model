package io.github.huherto.rbac.daos;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class UserRoleRealmTable extends BaseUserRoleRealmTable {

    private static final Log logger = LogFactory.getLog(UserRoleRealmTable.class);

    public UserRoleRealmTable(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected SimpleJdbcInsert buildInsert() {
        return super.buildInsert("USER_ROLE_REALM_ID");
    }

    public void makeFakeData(MyUserRecord user, RoleRecord role) {

        UserRoleRealmRecord nr = new UserRoleRealmRecord();

        nr.setRealm("GLOBAL");
        nr.setUserId(user.getUserId());
        nr.setRoleId(role.getRoleId());

        logger.debug(String.format("user:%d,role:%s",user.getUserId(), role.getRoleId()));

        this.insert(nr);

    }
}
