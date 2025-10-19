package com.social_mongo_graphql.social.DTO;

import java.time.Instant;
import java.util.List;

import com.social_mongo_graphql.social.model.Post;

import lombok.Data;

@Data
public class PostDTOOutput {
    
    private String id;
    private String authorId;
    private String content;
    private List<String> mediaUrls;
    private int likesCount = 0;
    private int commentsCount = 0;
    private Instant createdAt = Instant.now();

    public PostDTOOutput(Post post) {
        this.id = post.getId();
        this.authorId = post.getAuthorId();
        this.content = post.getContent();
        this.mediaUrls = post.getMediaUrls();
        this.likesCount = post.getLikesCount();
        this.commentsCount = post.getCommentsCount();
    }

}
