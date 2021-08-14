package org.mss.cdi;

import org.osgi.service.cdi.annotations.ComponentScoped;

import javax.enterprise.context.*;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Produces;
import javax.transaction.TransactionScoped;

public class MyProducer {

    /**
     * @Produces method must include a scope otherwise, cdi container may get confuse
     * as the default qualifiers are: @Default and @Any
     */
    @Produces
//    @ApplicationScoped
    @Dependent
    ClassHolder makeClassHolder(MyClass123 class1){
        return new ClassHolder(class1);
    }
}
