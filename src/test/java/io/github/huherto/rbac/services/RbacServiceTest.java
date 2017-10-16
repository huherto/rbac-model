package io.github.huherto.rbac.services;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import io.github.huherto.rbac.daos.RbacDatabase;

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
