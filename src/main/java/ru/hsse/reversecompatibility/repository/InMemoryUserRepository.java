package ru.hsse.reversecompatibility.repository;

import org.springframework.stereotype.Repository;
import ru.hsse.reversecompatibility.dto.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryUserRepository implements UserRepository{
    ArrayList<User> users;

    InMemoryUserRepository(){
        users = new ArrayList<>();
        users.add(new User(1L,"ivan@ivan.ru","Ivan","Ivanov", 24));
        users.add(new User(2L,"alex@ivan.ru","Alexander","Alexandrov",  18));
        users.add(new User(3L, "petr@petr.ru","Petr","Petrov",25));
    }

    @Override
    public List<User> UsersByRegex(String regex) {
      if (regex == ""){
        return users;
      }
      List <User> result = new ArrayList<User>();
      for(User curUser: users){
        if (curUser.login().matches(regex)){
            result.add(curUser);
        }
      }
      return result;
    }

}
