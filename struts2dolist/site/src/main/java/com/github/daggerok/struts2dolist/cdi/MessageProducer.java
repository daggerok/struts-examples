package com.github.daggerok.struts2dolist.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class MessageProducer {

    @Produces
    private String defaultMessage = "Hey!";
}
