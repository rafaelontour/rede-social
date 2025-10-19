package com.social_mongo_graphql.social.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.social_mongo_graphql.social.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}