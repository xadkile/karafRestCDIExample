package org.mss.jpa.ingredient;

import org.apache.aries.jpa.template.JpaTemplate;
import org.apache.aries.jpa.template.TransactionType;
import org.mss.jpa.booking.Booking;
import org.osgi.service.cdi.annotations.Reference;
import org.osgi.service.component.annotations.Component;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class IngredientJPA_CDIService {

    @Inject
    @Reference(target = "(osgi.unit.name=tacoCloudDbUnit)")
    private JpaTemplate jpaTemplate;

    public List<Ingredient> list() {
        return jpaTemplate.txExpr(TransactionType.Supports,
            entityManager -> entityManager.createQuery("SELECT b FROM Ingredient b", Ingredient.class).getResultList());
    }
}
