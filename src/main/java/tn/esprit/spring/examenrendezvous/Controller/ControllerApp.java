package tn.esprit.spring.examenrendezvous.Controller;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.examenrendezvous.Entity.*;
import tn.esprit.spring.examenrendezvous.Service.ServiceInterface;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("app")
@AllArgsConstructor
public class ControllerApp {

    ServiceInterface serviceInterface ;

    @PostMapping("addClinique")
    public Clinique addClinique(@RequestBody Clinique clinique) {
        return  serviceInterface.addClinique(clinique);
    }

    @PostMapping("addMedcin/{cliniqueId}")
    public Medcin addMedcin(@RequestBody Medcin medcin, @PathVariable Long cliniqueId) {
        return  serviceInterface.addMedecinAndAssignToClinique(medcin,cliniqueId);
    }

    @PostMapping("addPatient")
    public Patient addPatient(@RequestBody Patient patient) {
        return  serviceInterface.addPatient(patient);
    }

    @PostMapping("addRDV/{idMedcin}/{idPatient}")
    public void addRDV(@RequestBody RendezVous rendezVous, @PathVariable Long idMedcin, @PathVariable Long idPatient) {
         serviceInterface.addRDVAndAssignMedAndPatient(rendezVous,idMedcin,idPatient);
    }

    @GetMapping("getRDV/{idClinique}/{specialite}")
    public List<RendezVous> getRDVByCliniqueAndSpecialite(@PathVariable Long idClinique, @PathVariable Specialite specialite) {
        return  serviceInterface.getRendezVousByCliniqueAndSpecialite(idClinique, specialite);
    }

    @GetMapping("getRDV/{idMedecin}")
    public int getRDVCount(@PathVariable Long idMedecin) {
        return  serviceInterface.getNbrRendezVousMedecin(idMedecin);
    }


    @GetMapping("getRevenu/{idMedecin}/{startDate}/{endDate}")
    public int getRevenuMedecin (
            @PathVariable("idMedecin") Long idMedecin,
            @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
    ) {
        return  serviceInterface.getRevenuMedecin(idMedecin,startDate,endDate);
    }

}
