package daggerok.actions;

import com.opensymphony.xwork2.ActionSupport;
import lombok.extern.log4j.Log4j2;
import lombok.val;

import java.util.Date;

/**
 * ActionSupport provides:
 * - implements Action
 * - LocaleProvider
 * - TextProvider (messages)
 * - Validateable
 * - ValidationAware
 */
@Log4j2
public class HelloAction extends ActionSupport {

  private static final long serialVersionUID = -1401461151989527781L;

  @Override
  public String execute() throws Exception {
    log.info("executed at: {}", new Date());
    return SUCCESS;
  }

  public String getMessage() {
    val text = getText("hello.message");
    log.info("parsed from properties file: {}", text);
    return text;
  }
}
