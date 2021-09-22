package com.kontosystem.StiProjekt.userController;


import com.kontosystem.StiProjekt.userEntity.User;
import com.kontosystem.StiProjekt.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
public class RestController {

    @Autowired
    private UserService service; //Deklarerar(implementerar) att Controller använder UserService

    @PostMapping("/addUser")
    public User addProduct(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PostMapping("/addUsers")
    public List<User> addUser(@RequestBody List<User> users) {
        return service.saveUsers(users);
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return service.getUsers();
    }

    @GetMapping("/userById/{id}") // Pathvariable, här kan man använda @RequestParam oxå om det önskas
    public User findProductById(@PathVariable long id) {
        return service.getUserById(id);
    }

    @GetMapping("/user/{name}") // denna metod finns inte i JPA repo, skrev in själv. Ta en titt REPO Interface ser du det!!!
    public User findProductByName(@PathVariable String name) {
        return service.getUserByName(name);
    }

    @PutMapping("/update")//Jag får fel meddelande här 404, ska man kanske ha Pathvariable för veta vilken jag ska uppdatera? Eller??
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) { return service.deleteUser(id);

    }

}



