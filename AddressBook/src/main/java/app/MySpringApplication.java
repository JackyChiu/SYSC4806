package app;

import app.models.AddressBook;
import app.models.BuddyInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class MySpringApplication {
    private static final Logger log = LoggerFactory.getLogger(MySpringApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MySpringApplication.class);
    }
}
