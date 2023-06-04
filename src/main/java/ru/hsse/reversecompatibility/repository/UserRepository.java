package ru.hsse.reversecompatibility.repository;
import ru.hsse.reversecompatibility.dto.User;
import java.util.ArrayList;

public interface UserRepository {
  public ArrayList<User> UsersByRegex(String regex);

}
