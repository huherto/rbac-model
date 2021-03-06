package io.github.huherto.rbac;


import java.nio.file.Paths;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import io.github.huherto.springyRecords.generator.SchemaCrawlerGenerator;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... args) {
	    generateExample();
	}

	private void generateExample() {

	    String packageName = "io.github.huherto.rbac.daos";
	    String databaseClassName = "RBAC";
	    SchemaCrawlerGenerator dbGenerator = new SchemaCrawlerGenerator(dataSource(), packageName, databaseClassName);

	    // Base directory where code will be created.
	    dbGenerator.setBaseDir(Paths.get(".."));

	    // Use this to discover schemas and tables.
	    dbGenerator.printInformationSchema(null);

	    // Use this if you want to generate code for all the tables in a schema.
        dbGenerator.processAllTables("PUBLIC.PUBLIC");

    }

    @Bean
	public DataSource dataSource() {

        // Replace this with your own datasource.
        return new EmbeddedDatabaseBuilder()
                .setName("test")
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("classpath:hsql-schema.sql")
                .build();
	}
}
