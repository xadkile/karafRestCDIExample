package org.mss.cdi;

import org.osgi.service.cdi.annotations.Reference;
import org.osgi.service.cdi.annotations.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * This use constructor injection
 * mandatory condition:
 *  - A no-arg constructor
 */
//@ApplicationScoped
//@RequestScoped
@Dependent
public class MyService {
    MyClass123 class1;
    ClassHolder holder;

    /**
     * this no-arg constructor is a must, otherwise cdi container won't be able to construct the object
     */
    public MyService(){}

    @Inject
    public MyService(MyClass123 class1, ClassHolder holder) {
        this.class1 = class1;
        this.holder = holder;
    }

    public MyClass123 getClass1(){
        return class1;
    }

    public ClassHolder getHolder() {
        return this.holder;
    }

    public boolean checkSame(){
        return this.class1.hashCode() == this.holder.getClass1().hashCode();
    }
}
