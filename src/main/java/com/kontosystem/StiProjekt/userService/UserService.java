package com.kontosystem.StiProjekt.userService;


import com.kontosystem.StiProjekt.repository.UserRepository;
import com.kontosystem.StiProjekt.userEntity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class UserService {

    @Autowired
    private UserRepository repository; // Deklerar repositoryn här i service klass

    public User saveUser(User user) {
        return repository.save(user);
    }

    public List<User> saveUsers(List<User> users) {
        return repository.saveAll(users);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUserById(long id) {
        return repository.findById(id).orElse(null);
    }

    public User getUserByName(String name) {
        return repository.findByName(name);
    }

    public String deleteUser(long id) {
        repository.deleteById(id);
        return "Deleted User ID:  " + id;
    }

    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setAge(user.getAge());
        existingUser.setMail(user.getMail());
        existingUser.setPassword(user.getPassword());
        return repository.save(existingUser);
    }



}
