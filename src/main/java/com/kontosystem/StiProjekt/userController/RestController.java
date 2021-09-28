package com.kontosystem.StiProjekt.userController;


import com.kontosystem.StiProjekt.userEntity.User;
import com.kontosystem.StiProjekt.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
public class RestController {

    @Autowired
    private UserService service; //Deklarerar(implementerar) att Controller använder UserService

    //Import av Mediatype
    //Vi la in ett till dependency
    //Nu körs XML som standard, gå in på headers + lägg "Accept = Key  / application/json = Value", så ändras allt till Json.
    @PostMapping(path = "/{postUser}", consumes = {org.springframework.http.MediaType.APPLICATION_XML_VALUE, org.springframework.http.MediaType.APPLICATION_JSON_VALUE},
            produces = {org.springframework.http.MediaType.APPLICATION_XML_VALUE, org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public User addProduct(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PostMapping("/addUsers")
    public List<User> addUser(@RequestBody List<User> users) {
        return service.saveUsers(users);
    }

    @GetMapping(path = "/{users}", produces = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    public List<User> findAllUsers() {
            return service.getUsers();
    }


    @GetMapping(value="/userById/{id}", produces = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE}) // Pathvariable, här kan man använda @RequestParam oxå om det önskas
    public User findProductById(@PathVariable long id) {
        return service.getUserById(id);
        }

    //Funkar men använd på Unika namn
    @GetMapping(value="/user/{name}", produces = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE}) // denna metod finns inte i JPA repo, skrev in själv. Ta en titt REPO Interface ser du det!!!
    public User findProductByName(@PathVariable String name) {
        return service.getUserByName(name);
    }

    @PutMapping(path = "/{update}", consumes ={org.springframework.http.MediaType.APPLICATION_XML_VALUE, org.springframework.http.MediaType.APPLICATION_JSON_VALUE},
            produces = {org.springframework.http.MediaType.APPLICATION_XML_VALUE, org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    //Jag får fel meddelande här 404, ska man kanske ha Pathvariable för veta vilken jag ska uppdatera? Eller??
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @DeleteMapping(value="/delete/{id}",
    produces = {org.springframework.http.MediaType.APPLICATION_XML_VALUE, org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
    public String deleteUser(@PathVariable long id) { return service.deleteUser(id);

    }

}



