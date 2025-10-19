package com.social_mongo_graphql.social.DTO;

import lombok.Data;

@Data
public class CreateCommentInput {

    private String authorId;
    private String postId;
    private String content;
}
