package ru.hsse.reversecompatibility.dto.request;

import io.micrometer.common.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class requestVer3 {
  @Nullable
  private String likeString;
  @Nullable
  private String regexpString;
  @Nullable
  private String surname;
  @Nullable
  private Integer minAge;
  @Nullable
  private Integer maxAge;
}
