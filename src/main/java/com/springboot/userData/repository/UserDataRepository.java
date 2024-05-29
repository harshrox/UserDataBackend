package com.springboot.userData.repository;

import com.springboot.userData.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDataRepository extends MongoRepository<UserModel, String> {
}
