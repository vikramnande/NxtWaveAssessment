package com.vikram.nxtwave.Repository;

import com.vikram.nxtwave.Entity.User;
import com.vikram.nxtwave.Enum.UserType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository{

//    @Query("{}")
//    User findUser(String id);

    void saveUser(User user);

    List<User> getUsers(UserType requester);
}
