package daggerok.actions;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Data
@EqualsAndHashCode(callSuper = false)
public class IndexAction extends ActionSupport {

  private static final long serialVersionUID = -5976825320286132402L;

  String message;

  @Override
  @Action(value = "", results = {@Result(location = "./")})
  public String execute() throws Exception {
    message = "hello-hello!";
    return SUCCESS;
  }
}
