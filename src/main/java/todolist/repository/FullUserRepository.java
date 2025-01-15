package todolist.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import todolist.model.FullUser;
import org.springframework.stereotype.Repository;
import java.util.concurrent.ExecutionException;

@Repository
public class FullUserRepository {

    private final Firestore firestore;

    public FullUserRepository(Firestore firestore) {
        this.firestore = firestore;
    }

    private CollectionReference getUserCollection() {
        return firestore.collection("user"); // Nom exact de ta collection Firestore
    }

    public FullUser getUserById(String id) throws ExecutionException, InterruptedException {
        DocumentSnapshot doc = getUserCollection().document(id).get().get();
        return doc.exists() ? doc.toObject(FullUser.class) : null;
    }

    public String createUser(FullUser user) throws ExecutionException, InterruptedException {
        DocumentReference docRef = getUserCollection().document(); // nouvel ID auto-généré
        user.setId(docRef.getId());
        ApiFuture<WriteResult> future = docRef.set(user);
        future.get(); // bloque jusqu'à la fin de l'opération
        return docRef.getId();
    }

    public void updateUser(FullUser user) throws ExecutionException, InterruptedException {
        if (user.getId() == null) {
            throw new IllegalArgumentException("L'utilisateur doit avoir un ID pour être mis à jour");
        }
        DocumentReference docRef = getUserCollection().document(user.getId());
        docRef.set(user).get();
    }

    public void deleteUser(String id) throws ExecutionException, InterruptedException {
        getUserCollection().document(id).delete().get();
    }
}
