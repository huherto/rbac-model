package io.github.huherto.rbac.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BasePermissionRecord implements BaseRecord {
    private int permissionId;
    private String permissionName;

    public BasePermissionRecord() {
    }

    public BasePermissionRecord(BasePermissionRecord other) {
        this.permissionId = other.permissionId;
        this.permissionName = other.permissionName;
    }

    public BasePermissionRecord(ResultSet rs, int rowNum) throws SQLException {
        this.permissionId = rs.getInt("PERMISSION_ID");
        this.permissionName = rs.getString("PERMISSION_NAME");
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }


    @Override
    public Map<String, Object> asMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("PERMISSION_ID", this.permissionId);
        map.put("PERMISSION_NAME", this.permissionName);
        return map;
    }
}
