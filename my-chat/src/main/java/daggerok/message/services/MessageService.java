package daggerok.message.services;

import daggerok.message.domain.Message;
import daggerok.message.domain.MessageRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Stateless
public class MessageService implements Serializable {

  @Inject MessageRepository messageRepository;

  public void sendMessage(final MessageRequest sendMessageRequest) {

    if (Objects.isNull(sendMessageRequest)) return;

    final String messageBody = sendMessageRequest.getMessageBody();

    if (Objects.isNull(messageBody)) return;
    if (messageBody.trim().isEmpty()) return;

    final String identifier = sendMessageRequest.getMetadata()
                                                .values()
                                                .stream()
                                                .findFirst()
                                                .map(String::valueOf)
                                                .orElse("");

    messageRepository.save(Message.of(identifier, messageBody));
  }

  public List<MessageResponse> findLast100MessagesInDescendOrder() {
    final Function<ZonedDateTime, String> formatter = zonedDateTime -> DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
                                                                                        .format(zonedDateTime);
    return messageRepository.findLastMessagesOrderByCreatedAtDescLimit(100)
                            .stream()
                            .map(message -> MessageResponse.of(message.getBody(), formatter.apply(message.getCreatedAt())))
                            .collect(Collectors.toList());
  }
}
