package org.mss.jpa.ingredient;

import org.apache.aries.jpa.template.JpaTemplate;
import org.apache.aries.jpa.template.TransactionType;
import org.osgi.service.cdi.annotations.Reference;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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
