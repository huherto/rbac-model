package io.github.huherto.rbac;

import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class BaseDatabase extends JdbcDaoSupport {

    private MyUserTable myUserTable = null;
    private PermissionTable permissionTable = null;
    private RoleTable roleTable = null;
    private RolePermTable rolePermTable = null;
    private UserRoleRealmTable userRoleRealmTable = null;

    protected BaseDatabase(DataSource dataSource) {
        setDataSource(dataSource);
    }

    public MyUserTable myUserTable() {
        if (myUserTable == null) {
            myUserTable = new MyUserTable(getDataSource());
        }
        return myUserTable;
    }

    public PermissionTable permissionTable() {
        if (permissionTable == null) {
            permissionTable = new PermissionTable(getDataSource());
        }
        return permissionTable;
    }

    public RoleTable roleTable() {
        if (roleTable == null) {
            roleTable = new RoleTable(getDataSource());
        }
        return roleTable;
    }

    public RolePermTable rolePermTable() {
        if (rolePermTable == null) {
            rolePermTable = new RolePermTable(getDataSource());
        }
        return rolePermTable;
    }

    public UserRoleRealmTable userRoleRealmTable() {
        if (userRoleRealmTable == null) {
            userRoleRealmTable = new UserRoleRealmTable(getDataSource());
        }
        return userRoleRealmTable;
    }

}
