package ru.hsse.reversecompatibility.dto.response;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class responseVer2 {
  private ArrayList<String> logins;
  private Integer count;
}