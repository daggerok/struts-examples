package com.github.daggerok.struts2dolist.message;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Log4j2
@ApplicationScoped
public class MessageService {

    @Inject
    @Getter
    private String defaultMessage;

    @Getter
    private String globalState;

    @PostConstruct
    public void init() {
        log.debug("setup...");
        globalState = defaultMessage;
    }

    public String appendAndGet(String suffix) {
        log.debug("mutate global state...");
        globalState += " " + suffix;
        return globalState;
    }
}
