package tn.esprit.spring.examenrendezvous.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPatient ;

    String nomPatient ;

    int telephone ;

    Date dateNaissance ;

    @OneToMany(mappedBy = "patient")

    @JsonIgnore
    List<RendezVous> rendezVous;

}
