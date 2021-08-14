package org.mss.cdi;

import java.io.Serializable;

/**
 * ClassHolder is inject via a @Produces method in MyProducer
 * Mandatory condition:
 *  - A non-arg constructor
 */
public class ClassHolder implements Serializable {
    MyClass123 class1;

    public MyClass123 getClass1() {
        return class1;
    }

    public ClassHolder(MyClass123 class1) {
        this.class1 = class1;
    }

    /**
     * This constructor is a must in order for CDI to construct the object although there is already a @Produces method for it
     */
    public ClassHolder() {
    }
}
