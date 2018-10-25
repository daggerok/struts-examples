package daggerok.message.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class MessageRequest {
  final String messageBody;
  final Map<String, Object> metadata;
}
