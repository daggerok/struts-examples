package daggerok.rest;

import com.opensymphony.xwork2.ModelDriven;
import daggerok.user.UserRepository;
import io.vavr.control.Try;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import java.util.Date;
import java.util.UUID;

//tag::content[]
public class UserResource implements ModelDriven<Object> /* ModelDriven<User> */{

  private static final UserRepository users = new UserRepository();

  private String id;
  private Object model;

  public HttpHeaders index() {
    model = users.findAll();
    return new DefaultHttpHeaders("index").lastModified(new Date())
                                          .disableCaching()
        ;
  }

  public HttpHeaders show() {
    final UUID anId = Try.of(() -> UUID.fromString(id)).getOrElseGet(throwable -> null);
    model = null == anId ? users.findAll() : users.findById(anId);
    return new DefaultHttpHeaders("show").lastModified(new Date())
                                         .disableCaching()
        ;
  }

  @Override
  public Object getModel() {
    return model;
  }
}
//end::content[]
