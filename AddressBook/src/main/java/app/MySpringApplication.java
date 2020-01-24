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

    @Bean
    public CommandLineRunner demo(AddressBookRepository repository, BuddyInfoRepository respository2) {
        return (args) -> {
            AddressBook addressBook = new AddressBook();
            BuddyInfo b1 = new BuddyInfo("buddy name", "613934584");
            addressBook.addBuddy(b1);
            BuddyInfo b2 = new BuddyInfo("buddy2 name", "613934584");
            addressBook.addBuddy(b2);
            BuddyInfo b3 = new BuddyInfo("buddy3 name", "613934584");
            addressBook.addBuddy(b3);

            AddressBook addressBook2 = new AddressBook();
            addressBook2.addBuddy(b1);

            respository2.save(b1);
            respository2.save(b2);
            respository2.save(b3);

            repository.save(addressBook);
            repository.save(addressBook2);

            // fetch all
            log.info("app.models.AddressBook found with findAll():");
            log.info("-------------------------------");
            for (AddressBook ab : repository.findAll()) {
                log.info(ab.toString());
            }
            log.info("-------------------------------");

            AddressBook a = repository.findById(1);
            log.info("app.models.AddressBook found with findById(1):");
            log.info("--------------------------------");
            log.info(a.toString());
            log.info("--------------------------------");
        };
    }
}
