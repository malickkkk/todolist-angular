package todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"todolist", "repository", "model", "service", "controller", "config"})
public class App {

    @Value("${NAME:World}")
    String name;
    @RestController
    class HelloworldController {
        @GetMapping("/")
        String hello() {
            return "Hello " + name + "!";
        }
    }

    public static void main(String[] args) {
        String credsPath = System.getenv("GOOGLE_APPLICATION_CREDENTIALS");
        System.out.println("GOOGLE_APPLICATION_CREDENTIALS=" + credsPath);
        FirebaseInitializer.initialize();
        SpringApplication.run(App.class, args);
        Map<String, Object> data = new HashMap<>();
        data.put("nom", "Utilisateur");
        data.put("email", "utilisateur@example.com");
    }

}
