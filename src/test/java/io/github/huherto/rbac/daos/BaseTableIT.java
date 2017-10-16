package io.github.huherto.rbac.daos;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class BaseTableIT {

    private static BaseDatabase database = null;

    public BaseDatabase database() {
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

}