package io.exploretheweb.cloudfoundryapp.resource;

import io.exploretheweb.cloudfoundryapp.model.User;
import io.exploretheweb.cloudfoundryapp.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UsersRepository usersRepository;

    /* USER SAVING ENDPOINTS */

    @PostMapping("/load")
    @CachePut(value = "users")
    public List<User> loadUsers(@RequestBody final List<User> users) {
        System.out.println("Saving all the users in DB");
        return usersRepository.saveAll(users);
    }

    @PostMapping("")
    @CachePut(value = "users", key = "#user.name")
    public User saveUser(@RequestBody final User user) {
        System.out.println("Saving user in DB");
        return usersRepository.save(user);
    }

    /* USER FETCHING ENDPOINTS */

    @GetMapping("")
    @Cacheable(value = "users")
    public List<User> getUsers() {
        System.out.println("Fetching all users");
        return usersRepository.findAll();
    }

    @GetMapping("/{id}")
    @Cacheable(value = "users", key = "#id", condition = "#id > 2", unless = "#result.name.length() < 4")
    public User getUser(@PathVariable final Long id) {
        System.out.println("Fetching user by id : "+id);
        Optional<User> user = usersRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @GetMapping("/name/{name}")
    @Cacheable(value = "users", key = "#name")
    public List<User> getUserByName(@PathVariable final String name) {
        System.out.println("Fetching user by name : "+name);
        return usersRepository.findByName(name);
    }

    /* USER DELETION ENDPOINTS */

    @DeleteMapping("")
    @CacheEvict(value = "users", allEntries = true)
    public void deleteAllUsers() {
        System.out.println("Deleting all the users");
        usersRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "users", key = "#id")
    public void deleteUser(@PathVariable final Long id) {
        System.out.println("Deleting user by id : "+id);
        usersRepository.deleteById(id);
    }

    @DeleteMapping("/name/{name}")
    @CacheEvict(value = "users", key = "#name")
    public List<User> deleteUserByName(@PathVariable final String name) {
        System.out.println("Deleting user by name : "+name);
        return usersRepository.deleteByName(name);
    }

    /* CACHE CLEARING ENDPOINT */

    @GetMapping("/clearCache")
    @CacheEvict(value = "users", allEntries = true)
    public String clearCache() {
        return "Cleared User Cache";
    }

}
