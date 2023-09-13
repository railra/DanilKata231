package rahimov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rahimov.models.User;
import rahimov.services.PeopleService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final PeopleService peopleService;

    @Autowired
    public UserController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", peopleService.findAll());
        return "users/index";
    }

}
