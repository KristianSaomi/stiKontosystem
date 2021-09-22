package com.kontosystem.StiProjekt.userController;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model ;
import org.springframework.web.bind.annotation. GetMapping;
import org.springframework.web.bind.annotation. RequestParam;

import com.kontosystem.StiProjekt.userEntity.User;
import com.kontosystem.StiProjekt.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService service; //Deklarerar(implementerar) att Controller använder UserService


    @RequestMapping(value ="/users")
    public String getUsers(Model model) {
        List <User> users = service.getUsers();

        model.addAttribute("users", users);
        System.out.println(users.get(1));
        return "users";

    }
    @Controller

    public class GreetingController {
        @GetMapping("/greeting")
        public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
            model.addAttribute("name", name);
            return "greetings";
        }

    }
}

/*@RestController
@RequestMapping("/api/v1")
public class UserController {

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


 */
