package io.github.huherto.rbac.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BaseUserRoleRealmRecord implements BaseRecord {
    private int userRoleRealmId;
    private int userId;
    private int roleId;
    private String realm;

    public BaseUserRoleRealmRecord() {
    }

    public BaseUserRoleRealmRecord(BaseUserRoleRealmRecord other) {
        this.userRoleRealmId = other.userRoleRealmId;
        this.userId = other.userId;
        this.roleId = other.roleId;
        this.realm = other.realm;
    }

    public BaseUserRoleRealmRecord(ResultSet rs, int rowNum) throws SQLException {
        this.userRoleRealmId = rs.getInt("USER_ROLE_REALM_ID");
        this.userId = rs.getInt("USER_ID");
        this.roleId = rs.getInt("ROLE_ID");
        this.realm = rs.getString("REALM");
    }

    public int getUserRoleRealmId() {
        return userRoleRealmId;
    }

    public void setUserRoleRealmId(int userRoleRealmId) {
        this.userRoleRealmId = userRoleRealmId;
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
        map.put("USER_ROLE_REALM_ID", this.userRoleRealmId);
        map.put("USER_ID", this.userId);
        map.put("ROLE_ID", this.roleId);
        map.put("REALM", this.realm);
        return map;
    }
}
