package io.github.huherto.rbac;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class BaseMyUserRecord implements BaseRecord {
    private int userId;
    private String loginName;
    private String passwordValue;
    private String firstName;
    private String lastName;
    private String email;
    private String confirmValue;
    private Timestamp modifed;
    private Timestamp created;
    private Timestamp lastLogin;

    public BaseMyUserRecord() {
    }

    public BaseMyUserRecord(BaseMyUserRecord other) {
        this.userId = other.userId;
        this.loginName = other.loginName;
        this.passwordValue = other.passwordValue;
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.email = other.email;
        this.confirmValue = other.confirmValue;
        this.modifed = other.modifed;
        this.created = other.created;
        this.lastLogin = other.lastLogin;
    }

    public BaseMyUserRecord(ResultSet rs, int rowNum) throws SQLException {
        this.userId = rs.getInt("USER_ID");
        this.loginName = rs.getString("LOGIN_NAME");
        this.passwordValue = rs.getString("PASSWORD_VALUE");
        this.firstName = rs.getString("FIRST_NAME");
        this.lastName = rs.getString("LAST_NAME");
        this.email = rs.getString("EMAIL");
        this.confirmValue = rs.getString("CONFIRM_VALUE");
        this.modifed = rs.getTimestamp("MODIFED");
        this.created = rs.getTimestamp("CREATED");
        this.lastLogin = rs.getTimestamp("LAST_LOGIN");
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPasswordValue() {
        return passwordValue;
    }

    public void setPasswordValue(String passwordValue) {
        this.passwordValue = passwordValue;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmValue() {
        return confirmValue;
    }

    public void setConfirmValue(String confirmValue) {
        this.confirmValue = confirmValue;
    }

    public Timestamp getModifed() {
        return modifed;
    }

    public void setModifed(Timestamp modifed) {
        this.modifed = modifed;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }


    @Override
    public Map<String, Object> asMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("USER_ID", this.userId);
        map.put("LOGIN_NAME", this.loginName);
        map.put("PASSWORD_VALUE", this.passwordValue);
        map.put("FIRST_NAME", this.firstName);
        map.put("LAST_NAME", this.lastName);
        map.put("EMAIL", this.email);
        map.put("CONFIRM_VALUE", this.confirmValue);
        map.put("MODIFED", this.modifed);
        map.put("CREATED", this.created);
        map.put("LAST_LOGIN", this.lastLogin);
        return map;
    }
}
