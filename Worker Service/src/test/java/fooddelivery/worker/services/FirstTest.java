package fooddelivery.worker.services;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@SpringBootTest
public class FirstTest {



    @DynamicPropertySource
    static void pro(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url",sql::getJdbcUrl);
        registry.add("spring.datasource.password",sql::getPassword);
        registry.add("spring.datasource.username",sql::getUsername);

    }


    @Container
    public static MySQLContainer sql=new MySQLContainer()
            .withDatabaseName("test")
            .withUsername("test")
            .withPassword("test");



    @DisplayName("1 + 1 = 2")
    @Test
    void addition() {
        sql.start();
        String a=sql.getJdbcUrl();
        String b=sql.getUsername();
        String c=sql.getPassword();

        assertEquals(2, 3);
    }
}
