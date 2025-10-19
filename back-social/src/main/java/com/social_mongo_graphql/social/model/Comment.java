package com.social_mongo_graphql.social.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.time.Instant;


@Data
@Document(collection = "comments")
public class Comment {
    @Id
    private String id;
    
    private String postId;
    private String authorId;
    private String content;
    private Instant createdAt = Instant.now();
}