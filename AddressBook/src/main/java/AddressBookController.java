import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBookController implements ActionListener {
    private AddressBook addressBook;
    private AddressBookView view;

    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Create":
                this.addressBook = new AddressBook();
                break;
            case "Display":
                displayAddressBook();
                break;
            case "Add":
                addBuddyInfo();
                break;
        }
    }

    public void setView(AddressBookView view) {
        this.view = view;
    }

    private void addBuddyInfo() {
        if (!addressBookExists()) {
            return;
        }
        BuddyInfo b = new BuddyInfo();
        b.setName(this.view.inputDialog("Name"));
        b.setNumber(this.view.inputDialog("Phone Number"));

        this.addressBook.addBuddy(b);
    }

    private void displayAddressBook() {
        if (!addressBookExists()) {
            return;
        }
        this.view.showMessage("Buddies\n" + this.addressBook.toString());
    }

    private boolean addressBookExists() {
        if (this.addressBook != null) {
            return true;
        }
        this.view.showMessage("No AddressBook exists yet");
        return false;
    }
}
