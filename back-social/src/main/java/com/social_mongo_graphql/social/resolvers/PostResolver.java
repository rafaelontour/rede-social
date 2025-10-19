package com.social_mongo_graphql.social.resolvers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.social_mongo_graphql.social.DTO.PostDTOOutput;
import com.social_mongo_graphql.social.service.PostService;

@Controller
public class PostResolver {

    private final PostService ps;

    public PostResolver(PostService ps) {
        this.ps = ps;
    }
    
    @QueryMapping
    public PostDTOOutput getPostById(@Argument String id) {
        PostDTOOutput post = ps.getPostById(id);

        return post;
    }

    @QueryMapping
    public List<PostDTOOutput> timeline(@Argument String userId, @Argument int limit, @Argument int offset) {
        List<PostDTOOutput> timeline = ps.timeline(userId, limit, offset);

        return timeline;
    }

    @MutationMapping
    public PostDTOOutput createPost(@Argument PostDTOOutput post) {
        PostDTOOutput createdPost = ps.createPost(post);

        return createdPost;
    }

    @MutationMapping
    public Boolean likePost(@Argument String postId, @Argument String userId) {
        Boolean likedPost = ps.likePost(postId, userId);

        return likedPost;
    }
}
