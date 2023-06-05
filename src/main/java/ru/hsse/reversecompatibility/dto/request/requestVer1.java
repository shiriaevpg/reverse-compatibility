package ru.hsse.reversecompatibility.dto.request;

import io.micrometer.common.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class requestVer1 {
  @Nullable
  private String likeString;
  
}
