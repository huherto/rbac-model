package io.github.huherto.rbac.services;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import io.github.huherto.rbac.daos.RbacDatabase;

@RunWith(SpringRunner.class)
@WithUserDetails
@SpringBootTest
public class RbacServiceTest {

    private static RbacDatabase database = null;

    public RbacDatabase database() {
        if (database == null) {
            database = new RbacDatabase(createDs());
        }
        return database;
    }

    protected DataSource createDs() {

        // Replace this with your own datasource.
        return new EmbeddedDatabaseBuilder()
                .setName("test")
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("classpath:hsql-schema.sql")
                .build();
    }

    RbacService rbacService = new RbacService();

    @Test
    public void makeFakeData() {
        
        rbacService.rbacDatabase = database();

        rbacService.makeFakeData();
    }
}
