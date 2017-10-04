package io.github.huherto.rbac;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRoleRealmRecord extends BaseUserRoleRealmRecord {

    public UserRoleRealmRecord() {
    }

    public UserRoleRealmRecord(UserRoleRealmRecord other) {
        super(other);
    }

    public UserRoleRealmRecord(ResultSet rs, int rowNum) throws SQLException {
        super(rs, rowNum);
    }
}
