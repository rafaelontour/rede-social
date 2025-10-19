package com.social_mongo_graphql.social.DTO;

import java.util.List;

import lombok.Data;

@Data
public class CreatePostInput {
    
    private String authorId;
    private String content;
    private List<String> mediaUrls;
}
