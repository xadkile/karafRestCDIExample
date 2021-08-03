package org.mss.jpa;

import org.apache.aries.jpa.template.JpaTemplate;
import org.apache.aries.jpa.template.TransactionType;
import org.osgi.service.cdi.annotations.Service;
import org.osgi.service.component.annotations.Reference;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

//@Transactional
public class BookingJPAService {

//    @PersistenceContext(unitName = "tacoCloudDb")
//    private EntityManager entityManager;
//
//    public void setEntityManager(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Transactional(Transactional.TxType.REQUIRES_NEW)
//    public void add(Booking booking) {
//        entityManager.persist(booking);
//    }
//
//    @Transactional(Transactional.TxType.REQUIRES_NEW)
//    public void add(String flight, String customer) {
//        Booking booking = new Booking();
//        booking.setCustomer(customer);
//        booking.setFlight(flight);
//        entityManager.persist(booking);
//    }
//
//    @Transactional(Transactional.TxType.SUPPORTS)
//    public List<Booking> list() {
//        TypedQuery<Booking> query = entityManager.createQuery("SELECT b FROM Booking b", Booking.class);
//        return query.getResultList();
//    }
//
//    @Transactional(Transactional.TxType.SUPPORTS)
//    public Booking get(Long id) {
//        TypedQuery<Booking> query = entityManager.createQuery("SELECT b FROM Booking b WHERE b.id=:id", Booking.class);
//        query.setParameter("id", id);
//        Booking booking = null;
//        try {
//            booking = query.getSingleResult();
//        } catch (NoResultException e) {
//            // nothing to do
//        }
//        return booking;
//    }
//
//    @Transactional(Transactional.TxType.REQUIRES_NEW)
//    public void remove(Long id) {
//        Booking booking = get(id);
//        entityManager.remove(booking);
//    }
}
