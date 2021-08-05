package org.mss.rest;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Typed;

@ApplicationScoped
@Typed(ExampleServiceInterface.class) //this is optional, but I keep it here just in case I need to review
public class ExampleServiceImp implements ExampleServiceInterface, AnotherInterface{
    @Override
    public String doWork() {
        return "do work";
    }
}
