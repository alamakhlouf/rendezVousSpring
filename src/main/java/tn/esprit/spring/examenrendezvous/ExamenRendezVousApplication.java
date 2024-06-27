package tn.esprit.spring.examenrendezvous;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExamenRendezVousApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenRendezVousApplication.class, args);
    }

}
