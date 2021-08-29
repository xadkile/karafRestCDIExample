package org.mss.springconsumer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
//@ApplicationScoped
public class XCProvider {
    @Produces
    XC makeXC(){
        return new XC(-123);
    }

    // by default, @Produces method is prototype scope
    @Produces
    @ApplicationScoped
    @SingletonBank
    public Bank createBank() {
        return new BankOfAmerica("default");
    }
}
