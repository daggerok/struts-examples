package daggerok.actions;

import com.opensymphony.xwork2.ActionSupport;
import daggerok.message.Message;
import daggerok.message.MessageRepository;
import lombok.Setter;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.SessionAware;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@SessionScoped
public class IndexAction extends ActionSupport implements SessionAware {

  @Inject MessageRepository messageRepository;

  @Setter String body;
  @Setter Map<String, Object> session;

  void sendMessage() {
    if (Objects.isNull(body)) return;
    if (body.trim().isEmpty()) return;

    final Object key = session.values().stream().findFirst().orElse("");

    messageRepository.save(Message.of(String.valueOf(key), body));
  }

  @Override
  @Action("/*")
  public String execute() throws Exception {
    sendMessage();
    return "index";
  }

  public List<Message> getMessages() {
    return messageRepository.findLast100MessagesOrderByCreatedAtDesc();
  }
}
