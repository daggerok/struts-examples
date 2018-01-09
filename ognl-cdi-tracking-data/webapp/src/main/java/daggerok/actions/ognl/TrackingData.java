package daggerok.actions.ognl;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;

@Data
@Named("data")
@ApplicationScoped
@NoArgsConstructor
@Accessors(chain = true)
public class TrackingData implements Serializable {

  private static final long serialVersionUID = 2452869242077780285L;

  long total, goal = 555;
}
