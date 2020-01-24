import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Map<String, BuddyInfo> buddies;

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

}

