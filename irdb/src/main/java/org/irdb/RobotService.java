package org.irdb;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional(Transactional.TxType.SUPPORTS)
@ApplicationScoped
@Named //Gör så man kan komma åt metoderna i frontend
public class RobotService {

    @Inject
    EntityManager em; //EntityManager förkortas till em

    UUID uuid;
    
    //Lista alla robotar
    public List<Robot> findAll() {
        List<Robot> robots = em.createQuery("SELECT r FROM Robot r", Robot.class).getResultList(); //r för robot. SQL-kommandon med stora bokstäver
        return robots;
    }

    //Metoden för att hitta en robot
    public Robot find(Long id) {
        return em.find(Robot.class, id);
    }

    //Räkna hur många robotar som finns
    public Long countAll() {
        return em.createQuery("SELECT COUNT(r) FROM Robot r", Long.class).getSingleResult();
    }

    //Skapa robot
    @Transactional(Transactional.TxType.REQUIRED)
    public Robot create(Robot robot) {
        robot.setSerialNr(UUID.randomUUID());
        em.persist(robot);
        return robot;
    }

    //Ta bort robot
    @Transactional(Transactional.TxType.REQUIRED)
    public void delete(Long id) {
        em.remove(em.getReference(Robot.class, id));
    }
}
