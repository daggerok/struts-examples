package daggerok.actions;

import com.opensymphony.xwork2.ActionSupport;
import daggerok.actions.ognl.TrackingData;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

@Data
@Log4j2
@EqualsAndHashCode(callSuper = false)
public class IndexAction extends ActionSupport implements SessionAware {

  private static final long serialVersionUID = -4007015062585037937L;
  static final String KEY = "trackingData";

  long latest;
  TrackingData trackingData;
  Map<String, Object> session;

  public void resetTotal() {
    if (null == trackingData) return;
    trackingData.cleanTotal();
  }

  @Override
  @Action("/*")
  public String execute() throws Exception {

    trackingData = session.containsKey(KEY)
        ? (TrackingData) session.get(KEY)
        : new TrackingData(2500);

    trackingData.add(latest);
    session.put(KEY, trackingData);
    return "index";
  }

  @Override
  public void setSession(final Map<String, Object> session) {
    this.session = session;
  }
}
