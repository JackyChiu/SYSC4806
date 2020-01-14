import java.util.*;

public class AddressBook {
    HashMap<String, BuddyInfo> buddys;

    AddressBook() {
        this.buddys = new HashMap<String, BuddyInfo>();
    }

    public List<BuddyInfo> getBuddies() {
        List<BuddyInfo> values = new ArrayList<BuddyInfo>(this.buddys.values());
        return values;
    }

    public void addBuddy(BuddyInfo b) {
        this.buddys.put(b.getName(), b);
    }

    public void removeBuddy(BuddyInfo b) {
        this.buddys.remove(b.getName());
    }

    public int size() {
        return this.buddys.size();
    }

    public String toString() {
        String s = "";
        for (BuddyInfo b : this.getBuddies()) {
            s += b.toString() + "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        BuddyInfo b1 = new BuddyInfo("buddy name", "613934584");
        addressBook.addBuddy(b1);
        BuddyInfo b2 = new BuddyInfo("buddy2 name", "613934584");
        addressBook.addBuddy(b2);
        BuddyInfo b3 = new BuddyInfo("buddy3 name", "613934584");
        addressBook.addBuddy(b3);

        System.out.println(addressBook);
    }
}

