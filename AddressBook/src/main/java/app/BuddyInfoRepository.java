package app;

import app.models.AddressBook;
import app.models.BuddyInfo;
import org.springframework.data.repository.CrudRepository;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
    BuddyInfo findById(Integer id);
}