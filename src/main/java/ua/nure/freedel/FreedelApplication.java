package ua.nure.freedel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.dialect.MySQLDialect;
@SpringBootApplication
public class FreedelApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreedelApplication.class, args);
    }

}
