import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddressBookView extends JFrame {
    private ActionListener listener;

    private JMenu addressBookMenu() {
        JMenu menu = new JMenu("AddressBook");

        JMenuItem create = new JMenuItem("Create");
        create.addActionListener(this.listener);
        menu.add(create);

        JMenuItem display = new JMenuItem("Display");
        display.addActionListener(this.listener);
        menu.add(display);

        return menu;
    }

    private JMenu buddyInfoMenu() {
        JMenu menu = new JMenu("BuddyInfo");

        JMenuItem create = new JMenuItem("Add");
        create.addActionListener(this.listener);
        menu.add(create);

        return menu;
    }

    public void setListener(ActionListener al) {
        this.listener = al;
    }

    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(new JTextArea(), msg);
    }

    public String inputDialog(String msg) {
        return JOptionPane.showInputDialog(msg);
    }

    public void init() {
        this.add(this.addressBookMenu());
        this.add(this.buddyInfoMenu());

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new Dimension(600, 400));

        setVisible(true);
        setState(Frame.NORMAL);
    }
}