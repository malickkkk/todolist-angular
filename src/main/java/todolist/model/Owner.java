package todolist.model;

public class Owner {
    private String id;         // ID unique de l'utilisateur
    private String firstName;  // Prénom du propriétaire
    private String lastName;   // Nom du propriétaire

    // Constructeurs
    public Owner() {}

    public Owner(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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
}