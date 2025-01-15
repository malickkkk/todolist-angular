package todolist.model;

import java.util.Date;
import java.util.List;

public class Project {
    private String id;               // ID unique du projet
    private String name;             // Nom du projet
    private String description;      // Description du projet
    private String color;            // Couleur associée au projet
    private Date date;
    private List<String> column;     // Liste des colonnes
    private Owner owner;             // Propriétaire du projet
    private List<Task> task;        // Liste des taches



    // Constructeurs
    public Project() {}

    public Project(String id, String name, String description, String color, Date date, List<String> column, Owner owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.color = color;
        this.date = date;
        this.column = column;
        this.owner = owner;
    }

    // Getters et setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Task> getTask() {
        return task;
    }

    public void setTask(List<Task> tasks) {
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getColumn() {
        return column;
    }

    public void setColumn(List<String> column) {
        this.column = column;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
