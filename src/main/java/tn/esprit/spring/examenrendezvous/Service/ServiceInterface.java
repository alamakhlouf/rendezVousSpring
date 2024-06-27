package tn.esprit.spring.examenrendezvous.Service;

import tn.esprit.spring.examenrendezvous.Entity.*;

import java.util.Date;
import java.util.List;

public interface ServiceInterface {

    public Clinique addClinique(Clinique clinique);

    public Medcin addMedecinAndAssignToClinique(Medcin medecin, Long cliniqueId);

    public Patient addPatient(Patient patient);

    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long
            idPatient);

    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite);

    public int getNbrRendezVousMedecin(Long idMedecin);

    public void voidretrieveRendezVous();

    public  int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate);
}
