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
public class Clinique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idClinique ;
    String nomClinique ;
    String adresse ;
    int telephone ;

    @ManyToMany(mappedBy = "cliniques")

    @JsonIgnore
    List<Medcin> medcins = new ArrayList<>() ;
}
