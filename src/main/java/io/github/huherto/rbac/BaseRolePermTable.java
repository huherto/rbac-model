 package io.github.huherto.rbac;

import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BaseRolePermTable extends AbstractBaseTable<RolePermRecord> {

    private RowMapper<RolePermRecord> rm = new RowMapper<RolePermRecord>() {
        @Override
        public RolePermRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
             return new RolePermRecord(rs, rowNum);
        }
    };

    public BaseRolePermTable(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public RowMapper<RolePermRecord> rowMapper() {
        return rm;
    }

    @Override
    public String tableName() {
        return "ROLE_PERM";
    }

    public Optional<RolePermRecord> findByPK(int roleId, int permissionId) {
        String sql =
            selectStar() +
            "where ROLE_ID  = ? and PERMISSION_ID  = ? ";

        return optionalSingle(sql, roleId, permissionId);
    }
    
    public List<RolePermRecord> findByPermissionId(int permissionId) {
        String sql =
            selectStar() +
            "where PERMISSION_ID  = ? ";

        return query(sql, permissionId);
    }
    
    public List<RolePermRecord> findByRoleId(int roleId) {
        String sql =
            selectStar() +
            "where ROLE_ID  = ? ";

        return query(sql, roleId);
    }
    
    public List<RolePermRecord> findByRoleIdPermissionId(int roleId, int permissionId) {
        String sql =
            selectStar() +
            "where ROLE_ID  = ? and PERMISSION_ID  = ? ";

        return query(sql, roleId, permissionId);
    }
    
    
}
