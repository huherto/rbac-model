package io.github.huherto.rbac.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RolePermRecord extends BaseRolePermRecord {

    public RolePermRecord() {
    }

    public RolePermRecord(RolePermRecord other) {
        super(other);
    }

    public RolePermRecord(ResultSet rs, int rowNum) throws SQLException {
        super(rs, rowNum);
    }
}
