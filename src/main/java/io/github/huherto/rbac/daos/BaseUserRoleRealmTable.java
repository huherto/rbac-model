 package io.github.huherto.rbac.daos;

import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BaseUserRoleRealmTable extends AbstractBaseTable<UserRoleRealmRecord> {

    private RowMapper<UserRoleRealmRecord> rm = new RowMapper<UserRoleRealmRecord>() {
        @Override
        public UserRoleRealmRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
             return new UserRoleRealmRecord(rs, rowNum);
        }
    };

    public BaseUserRoleRealmTable(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public RowMapper<UserRoleRealmRecord> rowMapper() {
        return rm;
    }

    @Override
    public String tableName() {
        return "USER_ROLE_REALM";
    }

    public Optional<UserRoleRealmRecord> findByPK(int userRoleRealmId) {
        String sql =
            selectStar() +
            "where USER_ROLE_REALM_ID  = ? ";

        return optionalSingle(sql, userRoleRealmId);
    }
    
    public List<UserRoleRealmRecord> findByRoleId(int roleId) {
        String sql =
            selectStar() +
            "where ROLE_ID  = ? ";

        return query(sql, roleId);
    }
    
    public List<UserRoleRealmRecord> findByUserId(int userId) {
        String sql =
            selectStar() +
            "where USER_ID  = ? ";

        return query(sql, userId);
    }
    
    public List<UserRoleRealmRecord> findByUserRoleRealmId(int userRoleRealmId) {
        String sql =
            selectStar() +
            "where USER_ROLE_REALM_ID  = ? ";

        return query(sql, userRoleRealmId);
    }
    
    
}
