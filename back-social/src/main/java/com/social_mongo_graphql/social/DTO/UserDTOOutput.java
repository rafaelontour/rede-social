package com.social_mongo_graphql.social.DTO;

import java.time.Instant;

import lombok.Data;

@Data
public class UserDTOOutput {

    private String id;
    private String username;
    private String displayName;
    private String bio;
    private String avatarUrl;
    private String email;
    private Instant createdAt;
}
