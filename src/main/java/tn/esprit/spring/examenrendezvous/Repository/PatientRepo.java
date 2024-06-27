package tn.esprit.spring.examenrendezvous.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.examenrendezvous.Entity.Patient;

public interface PatientRepo extends JpaRepository<Patient,Long> {
}
