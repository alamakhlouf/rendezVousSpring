package tn.esprit.spring.examenrendezvous.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.examenrendezvous.Entity.Clinique;

@Repository
public interface CliniqueRepo extends JpaRepository<Clinique,Long> {
}
