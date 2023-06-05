package ru.hsse.reversecompatibility.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class responseVer2 {
  private List<String> logins;
  private Integer count;
}