import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.*;

@Entity
public class AddressBook {
    @Id
    private Integer id;
    private HashMap<String, BuddyInfo> buddies;

    AddressBook() {
        this.buddies = new HashMap<String, BuddyInfo>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<BuddyInfo> getBuddies() {
        List<BuddyInfo> values = new ArrayList<BuddyInfo>(this.buddies.values());
        return values;
    }

    public void addBuddy(BuddyInfo b) {
        this.buddies.put(b.getName(), b);
    }

    public void removeBuddy(BuddyInfo b) {
        this.buddies.remove(b.getName());
    }

    public int size() {
        return this.buddies.size();
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

