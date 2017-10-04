 package io.github.huherto.rbac;

import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BaseMyUserTable extends AbstractBaseTable<MyUserRecord> {

    private RowMapper<MyUserRecord> rm = new RowMapper<MyUserRecord>() {
        @Override
        public MyUserRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
             return new MyUserRecord(rs, rowNum);
        }
    };

    public BaseMyUserTable(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public RowMapper<MyUserRecord> rowMapper() {
        return rm;
    }

    @Override
    public String tableName() {
        return "MY_USER";
    }

    public Optional<MyUserRecord> findByPK(int userId) {
        String sql =
            selectStar() +
            "where USER_ID  = ? ";

        return optionalSingle(sql, userId);
    }
    
    public List<MyUserRecord> findByUserId(int userId) {
        String sql =
            selectStar() +
            "where USER_ID  = ? ";

        return query(sql, userId);
    }
    
    
}
