package daggerok.actions;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.struts2.convention.annotation.Action;

@Data
@EqualsAndHashCode(callSuper = false)
public class IndexAction extends ActionSupport {

  private static final long serialVersionUID = -5976825320286132402L;

  String freemarkerField;

  // same:
  @Override
  @Action("")
  public String execute() throws Exception {
    freemarkerField = "Hello, Freemarker action!";
    return "index";
  }

  public String getFreemarkerProperty() {
    return getText("freemarker.message");
  }
}
