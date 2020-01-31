package app.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BuddyInfo implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String number;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    private AddressBook addressBook;

    public BuddyInfo() {}

    public BuddyInfo(String name) {
        this.name = name;
    }

    public BuddyInfo(String name, String num) {
        this.name = name;
        this.number = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    public String toString() {
        return this.name + " " + this.number;
    }
}
