package com.social_mongo_graphql.social.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.time.Instant;


@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    @Indexed(unique = true)
    private String email;

    private String password;

    private String displayName;
    private String bio;
    private String avatarUrl;
    private Instant createdAt = Instant.now();
}