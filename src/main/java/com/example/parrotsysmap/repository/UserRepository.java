package com.example.parrotsysmap.repository;

import com.example.parrotsysmap.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserRepository extends MongoRepository<User, UUID> {
}
