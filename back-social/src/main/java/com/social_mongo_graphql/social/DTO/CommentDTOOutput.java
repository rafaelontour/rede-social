package com.social_mongo_graphql.social.DTO;

import java.time.Instant;

import lombok.Data;

@Data
public class CommentDTOOutput {

    private String id;
    private String authorId;
    private String content;
    private Instant createdAt;
}
