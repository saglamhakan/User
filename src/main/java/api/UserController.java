package api;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

@RestController
@RequestMapping(name = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User resultUser=userService.createUser(user);
        return ResponseEntity.ok(resultUser);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/getBy/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id){
        User user=userService.getUser(id);
        return ResponseEntity.ok(user);

    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user){
      User resultUser = userService.updateUser(id,user);
      return ResponseEntity.ok(resultUser);

    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id){
        Boolean status=userService.deleteUser(id);
        return ResponseEntity.ok(status);

    }
}
