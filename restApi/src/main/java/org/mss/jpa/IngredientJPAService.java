package org.mss.jpa;

import org.apache.aries.jpa.template.JpaTemplate;
import org.apache.aries.jpa.template.TransactionType;
import org.osgi.service.cdi.annotations.Service;
import org.osgi.service.component.annotations.Reference;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class IngredientJPAService {

    @Inject
    private EntityManager entityManager;
    public List<Ingredient> list() {
        if(entityManager==null){
            return new ArrayList<>();
        }else{
            TypedQuery<Ingredient> query = entityManager.createQuery("SELECT b FROM Ingredient b", Ingredient.class);
            return query.getResultList();
        }
    }
}
