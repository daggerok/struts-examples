package daggerok.actions;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.apache.struts2.convention.annotation.Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@Data
@Log4j2
@EqualsAndHashCode(callSuper = false)
public class IndexAction extends ActionSupport {

  private static final long serialVersionUID = -4007015062585037937L;

  String[] array = new String[] {"a 1", "a 2", "a 3", };
  List<String> list = asList("l 1", "l 2", "l 3");
  Map<String, Object> map = new HashMap<String, Object>() {{
    put("k 1", "v 1");
    put("k 2", "v 2");
    put("k 3", "v 3");
  }};

  @Override
  @Action("/*")
  public String execute() throws Exception {
    return "index";
  }
}
