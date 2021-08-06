package org.mss.jpa.ingredient;

import org.apache.aries.jpa.template.JpaTemplate;
import org.apache.aries.jpa.template.TransactionType;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(service = IngredientJPA_DSService.class, immediate = true)
public class IngredientJPA_DSService {
    // insert persistence unit name here
    @Reference(target = "(osgi.unit.name=tacoCloudDbUnit)")
    private JpaTemplate jpaTemplate;

    public List<Ingredient> list() {
        return jpaTemplate.txExpr(TransactionType.Supports,
            entityManager -> entityManager.createQuery("SELECT b FROM Ingredient b", Ingredient.class).getResultList());
    }
}
