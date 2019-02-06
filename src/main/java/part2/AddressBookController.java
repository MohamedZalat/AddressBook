package part2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressBookController {

    @Autowired
    AddressBookRepository repository;

    @GetMapping("/addressbook")
    public String newAddressBook(Model model) {
        AddressBook addressBook = new AddressBook();
        repository.save(addressBook);
        model.addAttribute("addressBook", addressBook);
        return "addressBookCompleted";
    }

}
