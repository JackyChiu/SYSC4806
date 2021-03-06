package app.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class AddressBook implements Serializable {
    @Id
    private Integer id;
    @JsonManagedReference
    @OneToMany(mappedBy = "addressBook", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Map<String, BuddyInfo> buddies;

    public AddressBook() {
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
        b.setAddressBook(this);
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

