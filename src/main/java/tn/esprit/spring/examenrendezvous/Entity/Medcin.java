package tn.esprit.spring.examenrendezvous.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Medcin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idMedecin;

    String nomMedecin;

    Specialite specialite;

    int telephone;

    int prixConsultation;

    @ManyToMany

    @JsonIgnore
    List<Clinique> cliniques = new ArrayList<>();

    @OneToMany(mappedBy = "medcin")

    @JsonIgnore
    List<RendezVous> rendezVous = new ArrayList<>();
}


