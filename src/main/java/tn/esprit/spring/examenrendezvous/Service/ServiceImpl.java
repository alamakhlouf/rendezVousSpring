package tn.esprit.spring.examenrendezvous.Service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.examenrendezvous.Entity.*;
import tn.esprit.spring.examenrendezvous.Repository.CliniqueRepo;
import tn.esprit.spring.examenrendezvous.Repository.MedecinRepo;
import tn.esprit.spring.examenrendezvous.Repository.PatientRepo;
import tn.esprit.spring.examenrendezvous.Repository.RendezVousRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ServiceImpl implements ServiceInterface {

    CliniqueRepo cliniqueRepo;
    MedecinRepo medecinRepo;
    PatientRepo patientRepo;
    RendezVousRepo rendezVousRepo;

    @Override
    public Clinique addClinique(Clinique clinique) {
        return cliniqueRepo.save(clinique);
    }

    @Override
    public Medcin addMedecinAndAssignToClinique(Medcin medecin, Long cliniqueId) {
        Clinique clinique = cliniqueRepo.findById(cliniqueId).orElse(null);
        List<Clinique> cliniques = medecin.getCliniques();
        cliniques.add(clinique);
        medecin.setCliniques(cliniques);

        return medecinRepo.save(medecin);
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public void addRDVAndAssignMedAndPatient(RendezVous rdv, Long idMedecin, Long idPatient) {
        Medcin medcin = medecinRepo.findById(idMedecin).orElse(null);
        Patient patient = patientRepo.findById(idPatient).orElse(null);
        rdv.setPatient(patient);
        rdv.setMedcin(medcin);
        rendezVousRepo.save(rdv);
    }

    @Override
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
        return rendezVousRepo.getAllByMedcinCliniquesIdCliniqueAndMedcinSpecialite(idClinique, specialite);
    }

    @Override
    public int getNbrRendezVousMedecin(Long idMedecin) {
        return rendezVousRepo.getAllByMedcinIdMedecin(idMedecin).size();
    }

    @Override
    @Scheduled(fixedRate = 30000)
    public void voidretrieveRendezVous() {
        LocalDate localDate = LocalDate.now();
        List<RendezVous> rendezVous = rendezVousRepo.getAllByDateRDVGreaterThan(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        for (RendezVous r : rendezVous) {
            System.out.println("La Liste Des RendezVous : " + r.getDateRDV() + " : Medecin: " + r.getMedcin().getNomMedecin() + " : Patient : " + r.getPatient().getNomPatient());
        }
    }

    @Override
    public int getRevenuMedecin(Long idMedecin, Date startDate, Date endDate) {
        List<RendezVous> rendezVous = rendezVousRepo.getAllByMedcinIdMedecinAndDateRDVBetween(idMedecin,startDate,endDate);
        if (!rendezVous.isEmpty()) {
        return rendezVous.size()*rendezVous.get(0).getMedcin().getPrixConsultation();}
        return  0 ;
    }
}
