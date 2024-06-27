package tn.esprit.spring.examenrendezvous.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.examenrendezvous.Entity.Medcin;

public interface MedecinRepo extends JpaRepository<Medcin,Long> {
}
