import org.junit.Test;

import javax.persistence.*;
import java.util.List;

import static org.junit.Assert.*;

public class AddressBookTest {
    @Test
    public void testAddBuddy() {
        AddressBook addressBook = new AddressBook();

        BuddyInfo buddyInfo = new BuddyInfo("buddy name", "613934584");
        addressBook.addBuddy(buddyInfo);

        BuddyInfo buddyInfo2 = new BuddyInfo("buddy2 name", "61333487");
        addressBook.addBuddy(buddyInfo2);

        assertTrue(addressBook.size() == 2);
    }

    @Test
    public void testRemoveBuddy() {
        AddressBook addressBook = new AddressBook();

        BuddyInfo buddyInfo = new BuddyInfo("buddy name", "613934584");
        addressBook.addBuddy(buddyInfo);

        BuddyInfo buddyInfo2 = new BuddyInfo("buddy2 name", "61333487");
        addressBook.addBuddy(buddyInfo2);

        assertTrue(addressBook.size() == 2);

        addressBook.removeBuddy(new BuddyInfo("buddy2 name"));
        assertTrue(addressBook.size() == 1);
    }

    @Test
    public void testPersist() {
        BuddyInfo b1 = new BuddyInfo("cool", "613");
        b1.setId(1);

        BuddyInfo b2 = new BuddyInfo("not-cool", "416");
        b2.setId(2);

        AddressBook ab = new AddressBook();
        ab.setId(1);
        ab.addBuddy(b1);
        ab.addBuddy(b2);

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(b1);
        em.persist(b2);
        em.persist(ab);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT ab FROM AddressBook ab");

        @SuppressWarnings("unchecked")
        AddressBook result = (AddressBook) q.getSingleResult();
        assertEquals((Integer) 1, result.getId());
        assertEquals(2, result.getBuddies().size());
        assertEquals("cool", result.getBuddies().get(0).getName());
        assertEquals("not-cool", result.getBuddies().get(1).getName());


        // Closing connection
        em.close();
        emf.close();
    }
}