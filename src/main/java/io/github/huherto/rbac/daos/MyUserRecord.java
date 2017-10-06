package io.github.huherto.rbac.daos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyUserRecord extends BaseMyUserRecord {

    public MyUserRecord() {
    }

    public MyUserRecord(MyUserRecord other) {
        super(other);
    }

    public MyUserRecord(ResultSet rs, int rowNum) throws SQLException {
        super(rs, rowNum);
    }
}
