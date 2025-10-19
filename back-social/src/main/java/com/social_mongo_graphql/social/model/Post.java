package com.social_mongo_graphql.social.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.social_mongo_graphql.social.DTO.CreateCommentInput;

import lombok.Data;

import java.time.Instant;
import java.util.List;


@Data
@Document(collection = "posts")
public class Post {
    @Id
    private String id;

    private String authorId; // referência ao usuário
    private String content;
    private List<String> mediaUrls;
    private Instant createdAt = Instant.now();
    private int likesCount = 0;
    private int commentsCount = 0;
    private List<CreateCommentInput> comments;
}