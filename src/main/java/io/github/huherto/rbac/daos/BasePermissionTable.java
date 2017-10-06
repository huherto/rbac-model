 package io.github.huherto.rbac.daos;

import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BasePermissionTable extends AbstractBaseTable<PermissionRecord> {

    private RowMapper<PermissionRecord> rm = new RowMapper<PermissionRecord>() {
        @Override
        public PermissionRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
             return new PermissionRecord(rs, rowNum);
        }
    };

    public BasePermissionTable(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public RowMapper<PermissionRecord> rowMapper() {
        return rm;
    }

    @Override
    public String tableName() {
        return "PERMISSION";
    }

    public Optional<PermissionRecord> findByPK(int permissionId) {
        String sql =
            selectStar() +
            "where PERMISSION_ID  = ? ";

        return optionalSingle(sql, permissionId);
    }
    
    public List<PermissionRecord> findByPermissionId(int permissionId) {
        String sql =
            selectStar() +
            "where PERMISSION_ID  = ? ";

        return query(sql, permissionId);
    }
    
    
}
