package lt.viko.eif.api.controllers;

import lt.viko.eif.api.models.User;
import lt.viko.eif.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class is an endpoint for accessing users
 */
@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    /**
     * This method retrieves all users
     *
     * @return user list with status
     */
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
