package todolist;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseInitializer {

    public static void initialize() {
        try {
            // Chargez les informations d'identification Firebase
            FileInputStream serviceAccount = new FileInputStream("src/main/resources/firebase-config.json");

            // Configurez Firebase avec les options
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://todolist-ece-b3-s1.firebaseio.com") // Modifiez avec l'URL de votre projet Firebase
                    .build();

            // Initialisez Firebase
            FirebaseApp.initializeApp(options);
            System.out.println("Firebase initialisé avec succès !");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de l'initialisation de Firebase : " + e.getMessage());
        }
    }
}
