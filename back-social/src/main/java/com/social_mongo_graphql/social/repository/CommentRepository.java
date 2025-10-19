package com.social_mongo_graphql.social.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.social_mongo_graphql.social.model.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByPostIdOrderByCreatedAtAsc(String postId);
}