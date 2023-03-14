package ua.denys.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ua.denys.facade.UserFacade;
import ua.denys.model.User;

@RestController
@RequestMapping(value = "/test")
@AllArgsConstructor
public class UserRestController {
    private UserFacade userFacade;

    @GetMapping(value = "/findUser/{id}")
    public User getUser(@PathVariable(value = "id") Long id) {
        return userFacade.findUser(id);
    }

    @PostMapping(value = "/addUser")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String addUser(@RequestBody User user) {
        Long id = userFacade.saveUser(user).getId();
        return "User successfully created: " + id;
    }
}
