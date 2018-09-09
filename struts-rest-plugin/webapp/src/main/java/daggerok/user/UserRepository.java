package daggerok.user;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class UserRepository {

  private static final Map<UUID, User> users = new ConcurrentHashMap<>();

  public UserRepository() {
    init();
  }

  private static void init() {
    users.computeIfAbsent(UUID.randomUUID(), id -> User.of(id, "Ololo Trololo", "ololo.trololo@gmail.com"));
    users.computeIfAbsent(UUID.randomUUID(), id -> User.of(id, "Trololo Ololo", "trololo.ololo@gmail.com"));
  }

  public User findById(final UUID id) {
    return users.getOrDefault(id, User.NOT_FOUND);
  }

  public Iterable<User> findAll() {
    return users.values();
  }

  public Map<UUID, User> db() {
    return users;
  }
}
