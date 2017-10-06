package io.github.huherto.rbac.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BaseUserRoleDomainRecord implements BaseRecord {
    private int userId;
    private int roleId;
    private String realm;

    public BaseUserRoleDomainRecord() {
    }

    public BaseUserRoleDomainRecord(BaseUserRoleDomainRecord other) {
        this.userId = other.userId;
        this.roleId = other.roleId;
        this.realm = other.realm;
    }

    public BaseUserRoleDomainRecord(ResultSet rs, int rowNum) throws SQLException {
        this.userId = rs.getInt("USER_ID");
        this.roleId = rs.getInt("ROLE_ID");
        this.realm = rs.getString("REALM");
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }


    @Override
    public Map<String, Object> asMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("USER_ID", this.userId);
        map.put("ROLE_ID", this.roleId);
        map.put("REALM", this.realm);
        return map;
    }
}
