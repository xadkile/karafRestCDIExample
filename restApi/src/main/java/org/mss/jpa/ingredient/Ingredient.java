package org.mss.jpa.ingredient;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Ingredient")
public class Ingredient{
    @Id
    String id;
    String name;
    String type;
}
