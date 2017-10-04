 package io.github.huherto.rbac;

import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BaseRoleTable extends AbstractBaseTable<RoleRecord> {

    private RowMapper<RoleRecord> rm = new RowMapper<RoleRecord>() {
        @Override
        public RoleRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
             return new RoleRecord(rs, rowNum);
        }
    };

    public BaseRoleTable(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public RowMapper<RoleRecord> rowMapper() {
        return rm;
    }

    @Override
    public String tableName() {
        return "ROLE";
    }

    public Optional<RoleRecord> findByPK(int roleId) {
        String sql =
            selectStar() +
            "where ROLE_ID  = ? ";

        return optionalSingle(sql, roleId);
    }
    
    public List<RoleRecord> findByRoleId(int roleId) {
        String sql =
            selectStar() +
            "where ROLE_ID  = ? ";

        return query(sql, roleId);
    }
    
    
}
