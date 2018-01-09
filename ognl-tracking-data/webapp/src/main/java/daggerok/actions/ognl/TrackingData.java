package daggerok.actions.ognl;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TrackingData {

  private static final TrackingData trackingData = new TrackingData();

  public static TrackingData getInstance() {
    return trackingData;
  }

  @Getter @Setter
  private long total, goal = 555;
}
