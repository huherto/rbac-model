package io.github.huherto.rbac;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRoleDomainRecord extends BaseUserRoleDomainRecord {

    public UserRoleDomainRecord() {
    }

    public UserRoleDomainRecord(UserRoleDomainRecord other) {
        super(other);
    }

    public UserRoleDomainRecord(ResultSet rs, int rowNum) throws SQLException {
        super(rs, rowNum);
    }
}
