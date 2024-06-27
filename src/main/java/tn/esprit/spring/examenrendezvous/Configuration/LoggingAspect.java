package tn.esprit.spring.examenrendezvous.Configuration;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @AfterReturning("execution(* tn.esprit.spring.examenrendezvous.Service.*.add*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        log.info("méthode exécutée");
    }
}
