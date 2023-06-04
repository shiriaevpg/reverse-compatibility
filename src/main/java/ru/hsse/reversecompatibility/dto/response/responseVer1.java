package ru.hsse.reversecompatibility.dto.response;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class responseVer1 {
  private ArrayList<String> logins;

}