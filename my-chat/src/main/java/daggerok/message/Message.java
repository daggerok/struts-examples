package daggerok.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PACKAGE;

@Getter
@AllArgsConstructor(staticName = "of", access = PACKAGE)
public class Message {

  final UUID id;
  final String name, body;
  final ZonedDateTime createdAt;

  public static Message of(final String name, final String body) {
    return Message.of(UUID.randomUUID(), name, body, ZonedDateTime.now());
  }
}
