package app;

import app.models.AddressBook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressBookController {
    private AddressBookRepository addressBookRepository;

    public AddressBookController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping("/")
    public String rootApplication() {
        return "application";
    }

    @ResponseBody
    @GetMapping("/addressBook")
    public AddressBook getAddressBook(@RequestParam("id") Integer id) {
        AddressBook addressBook = this.addressBookRepository.findById(id);
        return addressBook;
    }

    @ResponseBody
    @PostMapping(value = "/newAddressBook", produces = "application/json")
    public AddressBook newAddressBook(@RequestParam("id") Integer id) {
        AddressBook a = new AddressBook();
        a.setId(id);
        this.addressBookRepository.save(a);
        return a;
    }
}
