package daggerok.message.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PACKAGE;

@Getter
@NoArgsConstructor(access = PACKAGE)
@AllArgsConstructor(staticName = "of")
public class Message {

  UUID id;
  String name, body;
  ZonedDateTime createdAt;

  public static Message of(final String name, final String body) {
    return Message.of(UUID.randomUUID(), name, body, ZonedDateTime.now());
  }
}
