package tn.esprit.spring.examenrendezvous.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.examenrendezvous.Entity.RendezVous;
import tn.esprit.spring.examenrendezvous.Entity.Specialite;

import java.util.Date;
import java.util.List;

public interface RendezVousRepo extends JpaRepository<RendezVous,Long> {

    public List<RendezVous> getAllByMedcinCliniquesIdCliniqueAndMedcinSpecialite(Long idClinique, Specialite specialite);

    public  List<RendezVous> getAllByMedcinIdMedecin(Long idMedecin);

    public  List<RendezVous> getAllByDateRDVGreaterThan(Date date);

    public  List<RendezVous> getAllByMedcinIdMedecinAndDateRDVBetween(Long idMecin, Date dateDeb,Date dateFin);
}
