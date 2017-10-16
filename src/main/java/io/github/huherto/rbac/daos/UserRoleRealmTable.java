package io.github.huherto.rbac.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class UserRoleRealmTable extends BaseUserRoleRealmTable {

    private static final Log logger = LogFactory.getLog(UserRoleRealmTable.class);

    public UserRoleRealmTable(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected SimpleJdbcInsert buildInsert() {
        return super.buildInsert("USER_ROLE_REALM_ID");
    }

    public void makeFakeData(MyUserRecord user, RoleRecord role) {

        UserRoleRealmRecord nr = new UserRoleRealmRecord();

        nr.setRealm("GLOBAL");
        nr.setUserId(user.getUserId());
        nr.setRoleId(role.getRoleId());

        logger.debug(String.format("user:%d,role:%s",user.getUserId(), role.getRoleId()));

        this.insert(nr);

    }

    public static class UserRoleNameRealm extends UserRoleRealmRecord {

        public String roleName;
        
        public UserRoleNameRealm(ResultSet rs, int rowNum) throws SQLException {
            super(rs, rowNum);
            roleName = rs.getString("ROLE_NAME");
        }
        
        
    }
    
    public List<UserRoleNameRealm> findRoleWithNameByUserId(int userId) {
                
        String sql = 
                "select a.*, role.* from USER_ROLE_REALM a inner join role on a.role_id = role.role_id where user_id = ? ";
        
        RowMapper<UserRoleNameRealm> rm = new RowMapper<UserRoleNameRealm>() {

            @Override
            public UserRoleNameRealm mapRow(ResultSet rs, int rowNum) throws SQLException {                
                return new UserRoleNameRealm(rs, rowNum);
            }
            
        };
        
        return getJdbcTemplate().query(sql , rm, userId );
        
    }

    public int deleteByPK(Integer userRoleRealmId) {
        
        return update("delete from USER_ROLE_REALM where USER_ROLE_REALM_ID = ?", userRoleRealmId);
        
    }
}
