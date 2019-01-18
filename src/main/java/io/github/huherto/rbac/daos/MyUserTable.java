package io.github.huherto.rbac.daos;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyUserTable extends BaseMyUserTable {
    public MyUserTable(DataSource dataSource) {
        super(dataSource);
    }



    @Override
    protected SimpleJdbcInsert buildInsert() {
        return super.buildInsert("USER_ID");
    }

    public Optional<MyUserRecord> findByLoginName(String username) {
        
        String sql = selectStar() + " where LOGIN_NAME = ?";
        return optionalSingle(sql, username);
        
    }

}
