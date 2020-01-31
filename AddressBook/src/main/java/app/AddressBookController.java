package app;

import app.models.AddressBook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AddressBookController {
    private AddressBookRepository addressBookRepository;

    public AddressBookController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping("/addressBook")
    public String addressBook(@RequestParam("id") Integer id, Model model) {
        AddressBook addressBook = this.addressBookRepository.findById(id);
        model.addAttribute("addressBook", addressBook);
        return "addressBook";
    }
}
