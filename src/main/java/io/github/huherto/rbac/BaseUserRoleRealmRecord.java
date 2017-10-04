package io.github.huherto.rbac;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BaseUserRoleRealmRecord implements BaseRecord {
    private int userRoleDomainId;
    private int userId;
    private int roleId;
    private String realm;

    public BaseUserRoleRealmRecord() {
    }

    public BaseUserRoleRealmRecord(BaseUserRoleRealmRecord other) {
        this.userRoleDomainId = other.userRoleDomainId;
        this.userId = other.userId;
        this.roleId = other.roleId;
        this.realm = other.realm;
    }

    public BaseUserRoleRealmRecord(ResultSet rs, int rowNum) throws SQLException {
        this.userRoleDomainId = rs.getInt("USER_ROLE_DOMAIN_ID");
        this.userId = rs.getInt("USER_ID");
        this.roleId = rs.getInt("ROLE_ID");
        this.realm = rs.getString("REALM");
    }

    public int getUserRoleDomainId() {
        return userRoleDomainId;
    }

    public void setUserRoleDomainId(int userRoleDomainId) {
        this.userRoleDomainId = userRoleDomainId;
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
        map.put("USER_ROLE_DOMAIN_ID", this.userRoleDomainId);
        map.put("USER_ID", this.userId);
        map.put("ROLE_ID", this.roleId);
        map.put("REALM", this.realm);
        return map;
    }
}
