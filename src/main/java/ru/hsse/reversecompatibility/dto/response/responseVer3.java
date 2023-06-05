package ru.hsse.reversecompatibility.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.hsse.reversecompatibility.dto.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class responseVer3 {
  private List<User> users;
  private Integer count;
}
