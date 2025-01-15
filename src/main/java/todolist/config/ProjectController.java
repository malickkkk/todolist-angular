package todolist.config;

import todolist.model.Project;
import todolist.model.Task;
import org.springframework.web.bind.annotation.*;
import todolist.repository.ProjectRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // Récupérer un projet par ID
    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable String id) throws ExecutionException, InterruptedException {
        return projectRepository.getProjectById(id);
    }

    // Récupérer les tâches d’un projet
    @GetMapping("/{projectId}/tasks")
    public List<Task> getTasksByProject(@PathVariable String projectId) throws ExecutionException, InterruptedException {
        return projectRepository.getTasksByProjectId(projectId);
    }

    // Récupérer une tâche spécifique d’un projet
    @GetMapping("/{projectId}/tasks/{taskId}")
    public Task getTaskById(@PathVariable String projectId, @PathVariable String taskId) throws ExecutionException, InterruptedException {
        return projectRepository.getTaskById(projectId, taskId);
    }

    // Créer un nouveau projet
    @PostMapping
    public String createProject(@RequestBody Project project) throws ExecutionException, InterruptedException {
        return projectRepository.createProject(project);
    }

    // Mettre à jour un projet
    @PutMapping("/{id}")
    public void updateProject(@PathVariable String id, @RequestBody Project project) throws ExecutionException, InterruptedException {
        project.setId(id);
        projectRepository.updateProject(project);
    }

    // Supprimer un projet
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable String id) throws ExecutionException, InterruptedException {
        projectRepository.deleteProject(id);
    }

    // Créer une nouvelle tâche dans un projet
    @PostMapping("/{projectId}/tasks")
    public String createTask(@PathVariable String projectId, @RequestBody Task task) throws ExecutionException, InterruptedException {
        return projectRepository.createTask(projectId, task);
    }

    // Mettre à jour une tâche dans un projet
    @PutMapping("/{projectId}/tasks/{taskId}")
    public void updateTask(@PathVariable String projectId,
                           @PathVariable String taskId,
                           @RequestBody Task task) throws ExecutionException, InterruptedException {
        task.setId(taskId);
        projectRepository.updateTask(projectId, task);
    }

    // Supprimer une tâche dans un projet
    @DeleteMapping("/{projectId}/tasks/{taskId}")
    public void deleteTask(@PathVariable String projectId,
                           @PathVariable String taskId) throws ExecutionException, InterruptedException {
        projectRepository.deleteTask(projectId, taskId);
    }

}
