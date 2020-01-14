import org.junit.Test;

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
}