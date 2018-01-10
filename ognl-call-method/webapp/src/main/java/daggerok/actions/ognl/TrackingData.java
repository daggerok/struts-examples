package daggerok.actions.ognl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class TrackingData {

  long total;
  @NonNull long goal;

  public void add(final long latest) {
    total += latest;
  }

  public void cleanTotal() {
    total = 0;
  }
}
