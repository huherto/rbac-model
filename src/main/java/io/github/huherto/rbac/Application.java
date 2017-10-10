package io.github.huherto.rbac;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import io.github.huherto.rbac.daos.RbacDatabase;

@SpringBootApplication
public class Application {
    
    private static final Log logger = LogFactory.getLog(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public RbacDatabase getRbacDatabase() {
        
        logger.info("Creating datasource");
        
        DataSource dataSource = 
                new EmbeddedDatabaseBuilder()
                    .setName("test")
                    .setType(EmbeddedDatabaseType.HSQL)
                    .addScript("classpath:hsql-schema.sql")
                    .build();
        
        RbacDatabase db = new RbacDatabase(dataSource);
        return db;        
    }
    

}
