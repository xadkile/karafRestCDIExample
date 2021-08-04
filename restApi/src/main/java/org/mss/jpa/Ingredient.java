package org.mss.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ingredient {
    @Id
    String id;
    String name;
    String type;
}
