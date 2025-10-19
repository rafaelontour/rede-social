package com.social_mongo_graphql.social.DTO;

import lombok.Data;

@Data
public class CreateUserInput {

    private String username;
    private String displayName;
    private String email;
    private String password;
    private String bio;
    private String avatarUrl;
}
