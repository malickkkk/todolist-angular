package todolist.model;

public class Task {
    private String id;           // ID unique de la tâche
    private String name;         // Nom de la tâche
    private String description;  // Description de la tâche
    private int column;          // Colonne où se trouve la tâche
    private int number;          // Numéro ou ordre de la tâche
    private User user;           // Utilisateur assigné à la tâche

    // Constructeurs
    public Task() {}

    public Task(String id, String name, String description, int column, int number, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.column = column;
        this.number = number;
        this.user = user;
    }

    // Getters et setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}