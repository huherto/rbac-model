package io.github.huherto.rbac;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PermissionRecord extends BasePermissionRecord {

    public PermissionRecord() {
    }

    public PermissionRecord(PermissionRecord other) {
        super(other);
    }

    public PermissionRecord(ResultSet rs, int rowNum) throws SQLException {
        super(rs, rowNum);
    }
}
