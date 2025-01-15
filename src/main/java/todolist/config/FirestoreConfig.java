package todolist.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;

@Configuration
public class FirestoreConfig {

    @Bean
    public Firestore firestore() {
        // Remplace "ton-projet-id" par l'ID de ton projet GCP
        FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
                .setProjectId("todolist-ece-b3-s1")
                .build();
        return firestoreOptions.getService();
    }
}
