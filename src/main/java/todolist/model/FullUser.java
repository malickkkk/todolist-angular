package todolist.model;

import java.util.List;

public class FullUser {
    private String id;                 // ID unique de l'utilisateur
    private String firstName;          // Prénom
    private String lastName;           // Nom de famille
    private String email;              // Adresse e-mail
    private String role;               // Rôle (par exemple, "owner")
    private List<String> projects;     // Liste des IDs de projets associés

    // Constructeurs
    public FullUser() {}

    public FullUser(String id, String firstName, String lastName, String email, String role, List<String> projects) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.projects = projects;
    }

    // Getters et setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }
}