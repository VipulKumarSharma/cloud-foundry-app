package io.exploretheweb.cloudfoundryapp.resource;

import io.exploretheweb.cloudfoundryapp.model.User;
import io.exploretheweb.cloudfoundryapp.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("")
    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    @PostMapping("")
    public List<User> load(@RequestBody final List<User> users) {
        return usersRepository.saveAll(users);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable final Long id) {
        Optional<User> user = usersRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @GetMapping("/name/{name}")
    public List<User> getUserByName(@PathVariable final String name) {
        return usersRepository.findByName(name);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable final Long id) {
        usersRepository.deleteById(id);
    }

    @DeleteMapping("/name/{name}")
    public void deleteUserByName(@PathVariable final String name) {
        usersRepository.deleteByName(name);
    }

}
