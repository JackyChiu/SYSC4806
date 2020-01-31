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

    @GetMapping("/addressBook")
    public String getAddressBook(@RequestParam("id") Integer id, Model model) {
        AddressBook addressBook = this.addressBookRepository.findById(id);
        model.addAttribute("addressBook", addressBook);
        return "addressBook";
    }

    @ResponseBody
    @PostMapping(value = "/newAddressBook", produces = "application/json")
    public AddressBook newAddressBook() {
        AddressBook a = new AddressBook();
        this.addressBookRepository.save(a);
        return a;
    }
}
