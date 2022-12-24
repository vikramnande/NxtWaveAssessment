package com.vikram.nxtwave.Repository;

import com.vikram.nxtwave.Entity.User;
import com.vikram.nxtwave.Enum.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao implements UserRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public List<User> getUsers(UserType userType) {
        Query query = new Query();
        query.addCriteria(Criteria.where(User.CONSTANTS.USER_TYPE).is(userType));

        return mongoTemplate.find(query,User.class);
    }


}
