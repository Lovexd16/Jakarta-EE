package org.irdb;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional(Transactional.TxType.SUPPORTS)
public class RobotService {

    EntityManager em; //EntityManager förkortas till em
    
    //Lista alla robotar
    public List<Robot> findAll() {
        List<Robot> robots = em.createQuery("SELECT r FROM Robot r", Robot.class).getResultList(); //r för Robot. SQL-kommandon med stora bokstäver
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
        em.persist(robot);
        return robot;
    }

    //Ta bort robot
    @Transactional(Transactional.TxType.REQUIRED)
    public void delete(Long id) {
        em.remove(em.getReference(Robot.class, id));
    }
}