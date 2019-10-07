package com.github.daggerok.struts2dolist.actions;

import com.github.daggerok.struts2dolist.message.MessageService;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.apache.struts2.convention.annotation.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Objects;

@Results({
        @Result(name = "input", location = "index.jsp"),
        @Result(name = "success", location = "index.jsp"),
})
@Log4j2
@RequestScoped
// @Namespaces({
//         @Namespace(""),
//         @Namespace("/"),
// })
public class IndexPage extends ActionSupport {

    @Inject
    private MessageService messageService;

    @Getter
    private String message;

    @Setter
    private String body;

    @Override
    @Action("/send-message")
    public String input() throws Exception {
        final String globalState = messageService.getGlobalState();
        log.debug("writing: {}", body);
        if (Objects.nonNull(body)) this.message = messageService.appendAndGet(body);
        return SUCCESS;
    }

    @Override
    @Action("/*")
    public String execute() throws Exception {
        // final String globalState = messageService.getGlobalState();
        // log.debug("reading: {}", globalState);
        log.debug("reading...");
        this.message = messageService.appendAndGet("Hoy!");
        return SUCCESS;
    }
}
