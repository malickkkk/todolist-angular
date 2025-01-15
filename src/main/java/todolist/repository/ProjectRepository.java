package todolist.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import todolist.model.Project;
import todolist.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Repository
public class ProjectRepository {

    private final Firestore firestore;

    public ProjectRepository(Firestore firestore) {
        this.firestore = firestore;
    }

    private CollectionReference getProjectCollection() {
        return firestore.collection("projects");
    }

    // Récupérer un projet par son ID
    public Project getProjectById(String projectId) throws ExecutionException, InterruptedException {
        DocumentReference docRef = getProjectCollection().document(projectId);
        DocumentSnapshot doc = docRef.get().get();
        if (doc.exists()) {
            Project p = doc.toObject(Project.class);
            System.out.println("Projet trouvé : " + p);
            return p;
        } else {
            System.out.println("Aucun projet trouvé avec l'ID " + projectId);
        }
        return null;
    }
    // recupere un projet par la liste
    public List<Project> getProjectsById(List<String> projectIds) throws ExecutionException, InterruptedException {
        List<Project> projects = new ArrayList<>();
        for (String id : projectIds) {
            Project p = getProjectById(id);
            if (p != null) {
                projects.add(p);
            }
        }
        return projects;
    }

    // Récupérer la liste des tâches d’un projet
    public List<Task> getTasksByProjectId(String projectId) throws ExecutionException, InterruptedException {
        CollectionReference tasksRef = getProjectCollection().document(projectId).collection("task");
        QuerySnapshot querySnapshot = tasksRef.get().get();
        return querySnapshot.getDocuments().stream()
                .map(d -> d.toObject(Task.class))
                .collect(Collectors.toList());
    }

    // Récupérer une tâche spécifique par son ID dans un projet
    public Task getTaskById(String projectId, String taskId) throws ExecutionException, InterruptedException {
        DocumentReference docRef = getProjectCollection().document(projectId).collection("task").document(taskId);
        DocumentSnapshot doc = docRef.get().get();
        return doc.exists() ? doc.toObject(Task.class) : null;
    }

    // Créer un nouveau projet
    public String createProject(Project project) throws ExecutionException, InterruptedException {
        DocumentReference docRef = getProjectCollection().document();
        project.setId(docRef.getId());
        ApiFuture<WriteResult> future = docRef.set(project);
        future.get(); // attendre la fin de l'opération
        return docRef.getId();
    }

    // Mettre à jour un projet
    public void updateProject(Project project) throws ExecutionException, InterruptedException {
        if (project.getId() == null) {
            throw new IllegalArgumentException("Le projet doit avoir un ID pour être mis à jour");
        }
        DocumentReference docRef = getProjectCollection().document(project.getId());
        docRef.set(project).get();
    }

    // Supprimer un projet
    public void deleteProject(String projectId) throws ExecutionException, InterruptedException {
        DocumentReference docRef = getProjectCollection().document(projectId);
        docRef.delete().get();
    }

    public String createTask(String projectId, Task task) throws ExecutionException, InterruptedException {
        DocumentReference taskRef = getProjectCollection()
                .document(projectId)
                .collection("task")
                .document();  // ID auto-généré
        task.setId(taskRef.getId());
        ApiFuture<WriteResult> future = taskRef.set(task);
        future.get(); // bloque pour attendre l'opération Firestore
        return taskRef.getId();
    }

    public void updateTask(String projectId, Task task) throws ExecutionException, InterruptedException {
        if (task.getId() == null) {
            throw new IllegalArgumentException("La tâche doit avoir un ID pour être mise à jour");
        }
        DocumentReference taskRef = getProjectCollection()
                .document(projectId)
                .collection("task")
                .document(task.getId());
        taskRef.set(task).get(); // met à jour l'entité
    }

    public void deleteTask(String projectId, String taskId) throws ExecutionException, InterruptedException {
        DocumentReference taskRef = getProjectCollection()
                .document(projectId)
                .collection("task")
                .document(taskId);
        taskRef.delete().get();
    }

}
