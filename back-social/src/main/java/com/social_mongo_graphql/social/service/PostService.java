package com.social_mongo_graphql.social.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.social_mongo_graphql.social.DTO.PostDTOOutput;
import com.social_mongo_graphql.social.DTO.PostDTOInput;
import com.social_mongo_graphql.social.model.Post;
import com.social_mongo_graphql.social.repository.PostRepository;

@Service
public class PostService {
    
    private final PostRepository pr;

    public PostService(PostRepository pr) {
        this.pr = pr;
    }

    public PostDTOOutput getPostById(String id) {
        Post post = pr.findById(id).get();

        PostDTOOutput postToReturn = new PostDTOOutput(post);

        return postToReturn;
    }

    public List<PostDTOOutput> timeline(String userId, int limit, int offset) {
        // Pageable: primeiro parâmetro é o número da página (offset),
        // segundo é o tamanho da página (limit)
        PageRequest pageable = PageRequest.of(offset, limit);

        List<Post> timeline = pr.findByAuthorIdOrderByCreatedAtDesc(userId, pageable);

        List<PostDTOOutput> postsToReturn = timeline.stream().map(post -> new PostDTOOutput(post)).toList();

        return postsToReturn;
    }

    public PostDTOOutput createPost(PostDTOInput post) {
        Post postToSave = new Post();
        postToSave.setAuthorId(post.getAuthorId());
        postToSave.setContent(post.getContent());
        postToSave.setMediaUrls(post.getMediaUrls());

        Post createdPost = pr.save(postToSave);

        PostDTOOutput postToReturn = new PostDTOOutput(createdPost);

        return postToReturn;
    }

    public Boolean likePost(String postId, String userId) {
        
        Post post = pr.findById(postId).get();
        post.setLikesCount(post.getLikesCount() + 1);

        pr.save(post);

        return true;
    }
}
