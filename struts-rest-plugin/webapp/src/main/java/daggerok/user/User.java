package daggerok.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public class User {

  public static final User NOT_FOUND = User.of(
      UUID.fromString("00000000-0000-0000-0000-000000000000"),
      "Not Found",
      "not.found@invalid.mail"
  );

  @NonNull
  UUID id;
  @NonNull
  String name, email;
}
