package io.github.huherto.rbac.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BaseRoleRecord implements BaseRecord {
    private int roleId;
    private String roleName;

    public BaseRoleRecord() {
    }

    public BaseRoleRecord(BaseRoleRecord other) {
        this.roleId = other.roleId;
        this.roleName = other.roleName;
    }

    public BaseRoleRecord(ResultSet rs, int rowNum) throws SQLException {
        this.roleId = rs.getInt("ROLE_ID");
        this.roleName = rs.getString("ROLE_NAME");
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    @Override
    public Map<String, Object> asMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("ROLE_ID", this.roleId);
        map.put("ROLE_NAME", this.roleName);
        return map;
    }
}
