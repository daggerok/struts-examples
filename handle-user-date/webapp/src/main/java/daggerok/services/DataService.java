package daggerok.services;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DataService {

  private static String data;

  public static String set(final String newData) {

    return data = null == newData || newData.trim().length() < 1
        ? "" : new StringBuilder(newData).reverse()
                                         .toString();
  }

  public static String get() {
    return data;
  }
}
