package daggerok;

import com.opensymphony.xwork2.Action;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.Date;

@Data
@Log4j2
public class HelloAction implements Action {

  String message;

  @Override
  public String execute() throws Exception {
    log.info("executed at: {}", new Date());
    setMessage("ololo-trololo!");
    return "success";
  }
}
