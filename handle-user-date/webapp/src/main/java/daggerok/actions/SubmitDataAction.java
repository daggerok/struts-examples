package daggerok.actions;

import com.opensymphony.xwork2.ActionSupport;
import daggerok.services.DataService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
@EqualsAndHashCode(callSuper = false)
public class SubmitDataAction extends ActionSupport {

  private static final long serialVersionUID = -3772888384201225854L;

  String newData;

  @Override
  public String execute() throws Exception {
    log.info("data before: {}", newData);
    newData = DataService.set(newData);
    log.info("data after: {}", newData);
    return SUCCESS;
  }
}
