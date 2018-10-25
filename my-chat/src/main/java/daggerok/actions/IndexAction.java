package daggerok.actions;

import com.opensymphony.xwork2.ActionSupport;
import daggerok.message.services.MessageRequest;
import daggerok.message.services.MessageResponse;
import daggerok.message.services.MessageService;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.SessionAware;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@SessionScoped
public class IndexAction extends ActionSupport implements SessionAware {

  @Inject MessageService messageService;

  @Setter String body;
  @Setter Map<String, Object> session;

  @Override
  @Action("/*")
  @SneakyThrows
  public String execute() {
    final MessageRequest sendMessageRequest = MessageRequest.of(body, session);
    messageService.sendMessage(sendMessageRequest);
    return "index";
  }

  public List<MessageResponse> getMessages() {
    return messageService.findLast100MessagesInDescendOrder();
  }
}
