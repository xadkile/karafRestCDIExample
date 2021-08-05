package org.mss.jpa.ingredient;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@ApplicationScoped
//@Transactional
public class IngredientJPAService {

//    @Inject
//    @PersistenceContext(unitName = "tacoCloudDbUnit")
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
