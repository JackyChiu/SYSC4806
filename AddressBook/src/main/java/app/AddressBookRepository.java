package app;

import app.models.AddressBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "addressBook", path = "addressBooks")
public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
    AddressBook findById(@Param("id") Integer id);
}