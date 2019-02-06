package part2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class BuddyController {
    @Autowired
    BuddyInfoRepository repository;

    @GetMapping("/buddy")
    public String newBuddyInfo(Model model) {
        model.addAttribute("buddy", new BuddyInfo());
        return "newBuddyInfo";
    }

    @PostMapping("/buddy")
    public String newBuddyInfo(@ModelAttribute BuddyInfo bi, Model model) {

        BuddyInfo buddyInfo = new BuddyInfo(bi.getName(), bi.getPhoneNumber());
        repository.save(buddyInfo);
        model.addAttribute("buddy", buddyInfo);
        return "newBuddyInfoCompleted";
    }
}
