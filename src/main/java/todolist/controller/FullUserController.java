package todolist.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import todolist.model.FullUser;
import todolist.repository.FullUserRepository;

@RestController
@RequestMapping("/api/users")
public class FullUserController {

    private final FullUserRepository fullUserRepository;

    public FullUserController(FullUserRepository fullUserRepository) {
        this.fullUserRepository = fullUserRepository;
    }

    @GetMapping("/{id}")
    public FullUser getUserById(@PathVariable String id) throws ExecutionException, InterruptedException {
        return fullUserRepository.getUserById(id);
    }

    @PostMapping
    public String createUser(@RequestBody FullUser user) throws ExecutionException, InterruptedException {
        return fullUserRepository.createUser(user);
    }

    @PutMapping
    public void updateUser(@RequestBody FullUser user) throws ExecutionException, InterruptedException {
        fullUserRepository.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) throws ExecutionException, InterruptedException {
        fullUserRepository.deleteUser(id);
    }
}
