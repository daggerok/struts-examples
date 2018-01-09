package daggerok.actions;

import com.opensymphony.xwork2.ActionSupport;
import daggerok.actions.ognl.TrackingData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.apache.struts2.convention.annotation.Action;

@Data
@Log4j2
@EqualsAndHashCode(callSuper = false)
public class IndexAction extends ActionSupport {

  private static final long serialVersionUID = -4007015062585037937L;

  long latest;
  TrackingData trackingData;

  @Override
  @Action("")
  public String execute() throws Exception {
    trackingData = TrackingData.getInstance();
    trackingData.setTotal(latest + trackingData.getTotal());
    log.info("{}", Thread.currentThread());
    return "index";
  }
}
