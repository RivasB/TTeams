package cloud.tteams.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LogManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogManagementApplication.class, args);
    }

}
