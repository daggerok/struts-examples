package daggerok.actions;

import com.opensymphony.xwork2.ActionSupport;
import daggerok.services.DataService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
@EqualsAndHashCode(callSuper = false)
public class FindAllAction extends ActionSupport {

  private static final long serialVersionUID = 5608952388922937759L;

  String data;

  @Override
  public String execute() throws Exception {
    data = DataService.get();
    log.info("data: {}", data);
    return SUCCESS;
  }
}
