package app;

import app.models.AddressBook;
import org.springframework.data.repository.CrudRepository;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
    AddressBook findById(Integer id);
}