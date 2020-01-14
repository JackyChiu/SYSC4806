import org.junit.Test;

import javax.persistence.*;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class BuddyInfoTest {

    @Test
    public void getName() {
        BuddyInfo b = new BuddyInfo("cool");
        assertEquals(b.getName(), "cool");
    }

    @Test
    public void setName() {
        BuddyInfo b = new BuddyInfo("");
        b.setName("cool");
        assertEquals(b.getName(), "cool");
    }

    @Test
    public void getNumber() {
        BuddyInfo b = new BuddyInfo("cool", "foo");
        assertEquals(b.getNumber(), "foo");
    }

    @Test
    public void setNumber() {
        BuddyInfo b = new BuddyInfo("cool", "");
        b.setNumber("foo");
        assertEquals(b.getNumber(), "foo");
    }

    @Test
    public void performJPA() {
        BuddyInfo b1 = new BuddyInfo("cool", "613");
        b1.setId(1);

        BuddyInfo b2 = new BuddyInfo("not-cool", "416");
        b2.setId(2);

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

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM BuddyInfo b");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();
        assertEquals(2, results.size());
        assertEquals("not-cool",results.get(0).getName());
        assertEquals("cool", results.get(1).getName());

        // Closing connection
        em.close();
        emf.close();
    }
}