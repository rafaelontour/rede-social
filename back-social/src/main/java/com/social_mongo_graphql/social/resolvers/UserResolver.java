package com.social_mongo_graphql.social.resolvers;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.social_mongo_graphql.social.DTO.CreateUserInput;
import com.social_mongo_graphql.social.DTO.UserDTOOutput;
import com.social_mongo_graphql.social.service.UserService;

@Controller
public class UserResolver {

    private final UserService us;

    public UserResolver(UserService us) {
        this.us = us;
    }
    
    @QueryMapping
    public UserDTOOutput getUserById(@Argument String id) {
        UserDTOOutput user = us.getUserById(id);
        return user;
    }

    @QueryMapping
    public UserDTOOutput getUserByUsername(@Argument String username) {
        UserDTOOutput user = us.getUserByUsername(username);
        return user;
    }

    @MutationMapping
    public UserDTOOutput createUser(@Argument("input") CreateUserInput user) {
        UserDTOOutput createdUser = us.createUser(user);
        return createdUser;
    }
}
