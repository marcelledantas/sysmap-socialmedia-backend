package com.example.parrotsysmap.repository;

import com.example.parrotsysmap.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends MongoRepository<User, UUID> {
    User findUserByEmail(String email);

    Optional<User> findById(ObjectId userIdFollower);
}
