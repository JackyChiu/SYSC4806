import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BuddyInfo {
    @Id
    private Integer id;
    private String name;
    private String number;

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

    public String toString() {
        return this.name + " " + this.number;
    }
}
