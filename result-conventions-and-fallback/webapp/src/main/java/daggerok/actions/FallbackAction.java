package daggerok.actions;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.struts2.convention.annotation.Action;

@Data
@EqualsAndHashCode(callSuper = false)
public class FallbackAction extends ActionSupport {

  private static final long serialVersionUID = 2272970610386733903L;

  String message;

  @Override
  @Action("/*")
  public String execute() throws Exception {
    message = "this is: " + getClass().getSimpleName();
    return "fallback";
  }
}
