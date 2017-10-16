package io.github.huherto.rbac.daos;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class MyUserTable extends BaseMyUserTable {
    public MyUserTable(DataSource dataSource) {
        super(dataSource);
    }



    @Override
    protected SimpleJdbcInsert buildInsert() {
        return super.buildInsert("USER_ID");
    }

    public void makeFakeData() {

        MyUserRecord nr = new MyUserRecord();

        long localtime = Calendar.getInstance().getTime().getTime();

        nr.setUserId(0);
        nr.setLoginName("john");
        nr.setConfirmValue("");
        nr.setEmail("john@example.com");
        nr.setFirstName("John");
        nr.setLastName("Smith");
        nr.setLastLogin(new Timestamp(localtime));
        nr.setModifed(new Timestamp(localtime));
        nr.setPasswordValue("****");
        nr.setCreated(new Timestamp(localtime));

        this.insert(nr);

        for(int i = 0; i < 100; i++) {
            nr = new MyUserRecord();
            nr.setUserId(1);
            nr.setLoginName("sue");
            nr.setConfirmValue("");
            nr.setEmail("sue@example.com");
            nr.setFirstName("Sue");
            nr.setLastName("Williams");
            nr.setLastLogin(new Timestamp(localtime));
            nr.setModifed(new Timestamp(localtime));
            nr.setPasswordValue("****");
            nr.setCreated(new Timestamp(localtime));

            this.insert(nr);
        }
    }

}
