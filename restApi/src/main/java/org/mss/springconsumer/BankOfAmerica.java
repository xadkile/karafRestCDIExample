package org.mss.springconsumer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;

//@ApplicationScoped
@Dependent
@InstanceBank
public class BankOfAmerica implements Bank {
    String s;

    public BankOfAmerica(){
        this("");
    }

    public BankOfAmerica(String i){
        s = i;
    }
    @Override
    public String withdrawal() {
        return ("Withdrawal from Bank of America");
    }

    @Override
    public String deposit() {
        return (String.format("%s: Deposit to Bank of America", this.s));
    }
}
