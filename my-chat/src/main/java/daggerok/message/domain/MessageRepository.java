package daggerok.message.domain;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.Lock;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static javax.ejb.ConcurrencyManagementType.BEAN;
import static javax.ejb.LockType.WRITE;

@Startup
@Singleton
@ConcurrencyManagement(BEAN)
public class MessageRepository {

  Map<String, List<Message>> db;

  @PostConstruct
  public void init() {
    db = new ConcurrentHashMap<>();
  }

  @Lock(WRITE)
  public void save(final Message message) {
    db.putIfAbsent(message.name, new ArrayList<>());
    db.computeIfPresent(message.name, (name, messages) -> Stream.concat(messages.stream(),
                                                                        Stream.of(message))
                                                                .collect(Collectors.toList()));
  }

  public List<Message> findLastMessagesOrderByCreatedAtDescLimit(final long limit) {
    final Comparator<Message> descOrderComparator = (o1, o2) -> o2.createdAt.compareTo(o1.createdAt);
    final long messagesAmount = limit < 0 ? Long.MAX_VALUE : limit;
    return db.values()
             .stream()
             .flatMap(Collection::stream)
             .sorted(descOrderComparator)
             .limit(messagesAmount)
             .collect(Collectors.toList());
  }
}
