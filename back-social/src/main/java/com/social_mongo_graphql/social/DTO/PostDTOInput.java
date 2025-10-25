package com.social_mongo_graphql.social.DTO;

import java.util.List;

import com.social_mongo_graphql.social.model.Post;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // ✅ necessário para GraphQL instanciar via reflexão
public class PostDTOInput {
    
    private String authorId;
    private String content;
    private List<String> mediaUrls;

    public PostDTOInput(Post post) {
        this.authorId = post.getAuthorId();
        this.content = post.getContent();
        this.mediaUrls = post.getMediaUrls();
    }
}
