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
    public CommandLineRunner demo(BuddyInfoRepository repository, AddressBookRepository repository2) {
        return (args) -> {
            AddressBook addressBook = new AddressBook();
            BuddyInfo b1 = new BuddyInfo("buddy name", "613934584");
            b1.setAddressBook(addressBook);
            BuddyInfo b2 = new BuddyInfo("buddy2 name", "613934584");
            b2.setAddressBook(addressBook);
            BuddyInfo b3 = new BuddyInfo("buddy3 name", "613934584");
            b3.setAddressBook(addressBook);

            addressBook.addBuddy(b1);
            addressBook.addBuddy(b2);
            addressBook.addBuddy(b3);

            repository2.save(addressBook);

            // fetch all
            log.info("app.models.AddressBook found with findAll():");
            log.info("-------------------------------");
            for (AddressBook a : repository2.findAll()) {
                log.info(a.getId().toString());
            }
            log.info("-------------------------------");

            log.info("app.models.BuddyInfo found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo b : repository.findAll()) {
                log.info(b.toString());
            }
            log.info("-------------------------------");

            log.info("app.models.AddressBook found with findByName:");
            log.info("--------------------------------");
            for (BuddyInfo b : repository.findByName("buddy name")) {
                log.info(b.toString());
            }
            log.info("--------------------------------");

            log.info("app.models.AddressBook found with findByNumber:");
            log.info("--------------------------------");
            for (BuddyInfo b : repository.findByNumber("613934584")) {
                log.info(b.toString());
            }
            log.info("--------------------------------");
        };
    }
}
