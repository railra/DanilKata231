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

    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        peopleService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") int id, Model model){
        model.addAttribute("user", peopleService.findOne(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "users/new";
    }

}
