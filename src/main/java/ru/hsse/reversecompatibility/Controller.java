package ru.hsse.reversecompatibility;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.hsse.reversecompatibility.dto.User;
import ru.hsse.reversecompatibility.dto.request.*;
import ru.hsse.reversecompatibility.dto.response.*;
import ru.hsse.reversecompatibility.repository.UserRepository;

@RestController
public class Controller {
  UserRepository userRepository;

  @Autowired
  Controller(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping("v1/get")
  public responseVer1 ResponseV1(@RequestBody requestVer1 request) {
    String regexp = QueryConverter.LikeToRegex(request.getLikeString()); //сравнение с null перенесено в QueryConverter
    List<User> users = userRepository.UsersByRegex(regexp);
    List<String> logins = users.stream().map(User::login).collect(Collectors.toList());
    return new responseVer1(logins);
  }

  @PostMapping("v2/get")
  public responseVer2 ResponseV2(@RequestBody requestVer1 request) {
    String regexp = QueryConverter.LikeToRegex(request.getLikeString());
    List<User> users = userRepository.UsersByRegex(regexp);
    List<String> logins = users.stream().map(User::login).collect(Collectors.toList());
    return new responseVer2(logins, logins.size());
  }

  @PostMapping("v3/get")
  public responseVer3 ResponseV3(@RequestBody requestVer1 request) {
    String regexp = QueryConverter.LikeToRegex(request.getLikeString());
    List<User> result = userRepository.UsersByRegex(regexp);
    return new responseVer3(result, result.size());
  }

  @PostMapping("v4/get")
  public responseVer3 ResponseV4(@RequestBody requestVer2 request) {
    String regexp = (request.getRegexpString() == null) ? QueryConverter.LikeToRegex(request.getLikeString()) : request.getRegexpString();
    List<User> result = userRepository.UsersByRegex(regexp);
    return new responseVer3(result, result.size());
  }

  @PostMapping("v5/get")
  public responseVer3 ResponseV5(@RequestBody requestVer3 request) {
    String regexp = (request.getRegexpString() == null) ? QueryConverter.LikeToRegex(request.getLikeString()) : request.getRegexpString();
    List<User> result = userRepository.UsersByRegex(regexp).stream().filter(
      user -> (
      ((request.getMaxAge() == null) || Integer.compare(user.age(),request.getMaxAge()) <= 0) &&
      ((request.getMinAge() == null) || Integer.compare(user.age(),request.getMaxAge()) >= 0) &&
      ((request.getSurname() == null) || (request.getSurname().equals(user.surname())))
      )).toList();
    return new responseVer3(result, result.size());
  }

}
