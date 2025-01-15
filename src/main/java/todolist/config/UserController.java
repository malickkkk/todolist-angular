package todolist.config;
import org.springframework.web.bind.annotation.*;
import todolist.model.FullUser;
import todolist.model.Project;
import todolist.service.UserProjectService;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserProjectService userProjectService;

    public UserController(UserProjectService userProjectService) {
        this.userProjectService = userProjectService;
    }

    // --- CRÉER UN NOUVEL UTILISATEUR ---
    @PostMapping
    public String createUser(@RequestBody FullUser user) throws ExecutionException, InterruptedException {
        return userProjectService.createUser(user);
    }

    // --- RÉCUPÉRER UN UTILISATEUR PAR ID ---
    @GetMapping("/{id}")
    public FullUser getUser(@PathVariable String id) throws ExecutionException, InterruptedException {
        return userProjectService.getUserById(id);
    }

    // --- METTRE À JOUR UN UTILISATEUR ---
    @PutMapping("/{id}")
    public void updateUser(@PathVariable String id, @RequestBody FullUser user) throws ExecutionException, InterruptedException {
        user.setId(id);  // on s'assure que l'ID du body correspond à l'ID de l'URL
        userProjectService.updateUser(user);
    }

    // --- SUPPRIMER UN UTILISATEUR ---
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) throws ExecutionException, InterruptedException {
        userProjectService.deleteUser(id);
    }

    // --- RÉCUPÉRER LES PROJETS D’UN UTILISATEUR ---
    @GetMapping("/{id}/projects")
    public List<Project> getUserProjects(@PathVariable String id,
                                         @RequestParam(defaultValue = "false") boolean withTasks)
            throws ExecutionException, InterruptedException {
        return userProjectService.getProjectsForUser(id, withTasks);
    }
}