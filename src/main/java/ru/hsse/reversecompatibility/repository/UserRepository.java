package ru.hsse.reversecompatibility.repository;
import ru.hsse.reversecompatibility.dto.User;
import java.util.List;

public interface UserRepository {
  public List<User> UsersByRegex(String regex);

}
