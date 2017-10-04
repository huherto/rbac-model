 package io.github.huherto.rbac;

import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BaseUserRoleDomainTable extends AbstractBaseTable<UserRoleDomainRecord> {

    private RowMapper<UserRoleDomainRecord> rm = new RowMapper<UserRoleDomainRecord>() {
        @Override
        public UserRoleDomainRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
             return new UserRoleDomainRecord(rs, rowNum);
        }
    };

    public BaseUserRoleDomainTable(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public RowMapper<UserRoleDomainRecord> rowMapper() {
        return rm;
    }

    @Override
    public String tableName() {
        return "USER_ROLE_DOMAIN";
    }

    public Optional<UserRoleDomainRecord> findByPK(int userId, int roleId, String realm) {
        String sql =
            selectStar() +
            "where USER_ID  = ? and ROLE_ID  = ? and REALM  = ? ";

        return optionalSingle(sql, userId, roleId, realm);
    }
    
    public List<UserRoleDomainRecord> findByUserId(int userId) {
        String sql =
            selectStar() +
            "where USER_ID  = ? ";

        return query(sql, userId);
    }
    
    public List<UserRoleDomainRecord> findByUserIdRoleId(int userId, int roleId) {
        String sql =
            selectStar() +
            "where USER_ID  = ? and ROLE_ID  = ? ";

        return query(sql, userId, roleId);
    }
    
    public List<UserRoleDomainRecord> findByUserIdRoleIdRealm(int userId, int roleId, String realm) {
        String sql =
            selectStar() +
            "where USER_ID  = ? and ROLE_ID  = ? and REALM  = ? ";

        return query(sql, userId, roleId, realm);
    }
    
    
}
