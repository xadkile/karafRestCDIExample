package org.mss.jpa;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EmProducer {
    @Produces
    @PersistenceContext(unitName = "tacoCloudDb")
    private EntityManager manager;
}
