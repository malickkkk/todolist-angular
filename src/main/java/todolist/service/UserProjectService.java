package todolist.service;

import todolist.model.FullUser;
import todolist.model.Project;
import todolist.model.Task;
import todolist.repository.FullUserRepository;
import todolist.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserProjectService {

    private final FullUserRepository userRepository;
    private final ProjectRepository projectRepository;

    public UserProjectService(FullUserRepository userRepository, ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }

    public String createUser(FullUser user) throws ExecutionException, InterruptedException {
        return userRepository.createUser(user);
    }

    public FullUser getUserById(String userId) throws ExecutionException, InterruptedException {
        return userRepository.getUserById(userId);
    }

    public void updateUser(FullUser user) throws ExecutionException, InterruptedException {
        userRepository.updateUser(user);
    }

    public void deleteUser(String userId) throws ExecutionException, InterruptedException {
        userRepository.deleteUser(userId);
    }

    // Méthode existante pour récupérer projets d'un user
    public List<Project> getProjectsForUser(String userId, boolean withTasks) throws ExecutionException, InterruptedException {
        FullUser user = getUserById(userId);
        if (user == null) {
            return List.of(); // ou lève une exception si tu préfères
        }

        List<Project> userProjects = projectRepository.getProjectsById(user.getProjects());
        if (withTasks) {
            // Pour chaque projet, charge les tâches
            for (Project project : userProjects) {
                project.setTask(projectRepository.getTasksByProjectId(project.getId()));
            }
        }
        return userProjects;
    }
}