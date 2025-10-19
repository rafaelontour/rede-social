package com.social_mongo_graphql.social.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.social_mongo_graphql.social.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByAuthorIdOrderByCreatedAtDesc(String authorId, PageRequest pageable);
}