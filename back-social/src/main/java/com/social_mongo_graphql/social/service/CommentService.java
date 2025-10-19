package com.social_mongo_graphql.social.service;

import org.springframework.stereotype.Service;

import com.social_mongo_graphql.social.DTO.CommentDTOOutput;
import com.social_mongo_graphql.social.DTO.CreateCommentInput;
import com.social_mongo_graphql.social.model.Comment;
import com.social_mongo_graphql.social.repository.CommentRepository;

@Service
public class CommentService {

    private final CommentRepository cr;

    public CommentService(CommentRepository cr) {
        this.cr = cr;
    }

    public CommentDTOOutput createComment(CreateCommentInput comment) {
        Comment newComment = new Comment();
        newComment.setPostId(comment.getPostId());
        newComment.setAuthorId(comment.getAuthorId());
        newComment.setContent(comment.getContent());
        
        Comment savedComment = cr.save(newComment);

        CommentDTOOutput commentToReturn = new CommentDTOOutput();
        commentToReturn.setId(savedComment.getId());
        commentToReturn.setAuthorId(savedComment.getAuthorId());
        commentToReturn.setContent(savedComment.getContent());

        return commentToReturn;
    }
}
