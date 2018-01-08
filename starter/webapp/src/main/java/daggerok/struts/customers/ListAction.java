package daggerok.struts.customers;

import com.opensymphony.xwork2.Action;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.Date;

@Data
@Log4j2
public class ListAction implements Action {

  String messageToCustomers;

  @Override
  public String execute() throws Exception {
    log.info("now is: ${}", new Date());
    messageToCustomers = "list of customers....";
    return SUCCESS;
  }
}
