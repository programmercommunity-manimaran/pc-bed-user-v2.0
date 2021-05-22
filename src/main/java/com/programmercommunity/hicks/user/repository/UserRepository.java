package com.programmercommunity.hicks.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.programmercommunity.hicks.user.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
