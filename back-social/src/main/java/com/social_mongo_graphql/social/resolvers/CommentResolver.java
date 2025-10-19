package com.social_mongo_graphql.social.resolvers;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;

import com.social_mongo_graphql.social.DTO.CommentDTOOutput;
import com.social_mongo_graphql.social.DTO.CreateCommentInput;
import com.social_mongo_graphql.social.service.CommentService;

@Controller
public class CommentResolver {
    
    private final CommentService cs;

    public CommentResolver(CommentService cs) {
        this.cs = cs;
    }

    public CommentDTOOutput createComment(@Argument CreateCommentInput comment) {
        CommentDTOOutput createdComment = cs.createComment(comment);
        return createdComment;
    }
}
