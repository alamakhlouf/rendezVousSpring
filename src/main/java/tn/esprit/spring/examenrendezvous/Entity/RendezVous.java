package tn.esprit.spring.examenrendezvous.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idRDV ;

    Date dateRDV ;

    String remarque ;

    @ManyToOne
    @JsonIgnore
    Medcin medcin ;

    @ManyToOne
    @JsonIgnore
    Patient patient;
}
