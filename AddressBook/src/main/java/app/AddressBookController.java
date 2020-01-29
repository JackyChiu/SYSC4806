package app;

import app.models.AddressBook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressBookController {
    private AddressBookRepository addressBookRepository;

    public AddressBookController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping("/addressBook")
    public String getAddressBook(Model model) {
        Iterable<AddressBook> addressBooks = this.addressBookRepository.findAll();
        model.addAttribute("addressBooks", addressBooks);
        return "addressBook";
    }
}
