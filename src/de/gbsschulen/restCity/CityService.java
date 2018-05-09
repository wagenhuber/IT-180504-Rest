package de.gbsschulen.restCity;

import de.gbsschulen.rest.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CityService {

    private EntityManagerFactory emf;
    private EntityManager em;

    public CityService() {
        emf = Persistence.createEntityManagerFactory("cities");
        em = emf.createEntityManager();
    }

    public void close() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }

    }

    public City getCity(int id) {
        return em.find(City.class, id);
    }


}
