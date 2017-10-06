package io.github.huherto.rbac.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BaseRolePermRecord implements BaseRecord {
    private int roleId;
    private int permissionId;

    public BaseRolePermRecord() {
    }

    public BaseRolePermRecord(BaseRolePermRecord other) {
        this.roleId = other.roleId;
        this.permissionId = other.permissionId;
    }

    public BaseRolePermRecord(ResultSet rs, int rowNum) throws SQLException {
        this.roleId = rs.getInt("ROLE_ID");
        this.permissionId = rs.getInt("PERMISSION_ID");
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }


    @Override
    public Map<String, Object> asMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("ROLE_ID", this.roleId);
        map.put("PERMISSION_ID", this.permissionId);
        return map;
    }
}
