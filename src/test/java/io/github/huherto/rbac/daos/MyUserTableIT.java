package io.github.huherto.rbac.daos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;
import java.util.Calendar;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyUserTableIT extends BaseTableIT {

    public MyUserTable table() {
        return database().myUserTable();
    }

    @Test
    public void testNotNull() {
        assertNotNull(table());

    }
    
    public static int dataFakedCount = 0;
    
    public static int makeFakeData(MyUserTable table) {
        
        if (dataFakedCount > 0)
            return dataFakedCount;

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);

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
        nr.setPasswordValue(encoder.encode("john"));
        nr.setCreated(new Timestamp(localtime));

        table.insert(nr);
        dataFakedCount++;

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

            table.insert(nr);
            dataFakedCount++;
        }                
        
        return dataFakedCount;
    }

    @Test
    public void testFakeData() {

        int count = makeFakeData(table());

        assertEquals(count, table().queryAll().size());

    }


}
