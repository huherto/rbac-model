package io.github.huherto.rbac.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRecord extends BaseRoleRecord {

    public RoleRecord() {
    }

    public RoleRecord(RoleRecord other) {
        super(other);
    }

    public RoleRecord(ResultSet rs, int rowNum) throws SQLException {
        super(rs, rowNum);
    }
}
