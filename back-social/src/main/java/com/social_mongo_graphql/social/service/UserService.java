package com.social_mongo_graphql.social.service;

import org.springframework.stereotype.Service;

import com.social_mongo_graphql.social.DTO.CreateUserInput;
import com.social_mongo_graphql.social.DTO.UserDTOOutput;
import com.social_mongo_graphql.social.model.User;
import com.social_mongo_graphql.social.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository ur;

    public UserService(UserRepository ur) {
        this.ur = ur;
    }

    public UserDTOOutput getUserById(String id) {
        User user = ur.findById(id).get();

        UserDTOOutput userToReturn = new UserDTOOutput();
        userToReturn.setUsername(user.getUsername());
        userToReturn.setEmail(user.getEmail());
        return userToReturn;
    }

    public UserDTOOutput getUserByUsername(String username) {
        User user = ur.findByUsername(username).get();

        UserDTOOutput userToReturn = new UserDTOOutput();
        userToReturn.setId(user.getId());
        userToReturn.setUsername(user.getUsername());
        userToReturn.setEmail(user.getEmail());
        userToReturn.setDisplayName(user.getDisplayName());
        userToReturn.setAvatarUrl(user.getAvatarUrl());
        userToReturn.setBio(username);
        return userToReturn;
    }

    public UserDTOOutput createUser(CreateUserInput user) {

        // Cria um model pra salvar no banco
        User userToSave = new User();
        userToSave.setUsername(user.getUsername());
        userToSave.setEmail(user.getEmail());
        userToSave.setPassword(user.getPassword());
        userToSave.setDisplayName(user.getDisplayName());
        userToSave.setAvatarUrl(user.getAvatarUrl());
        userToSave.setBio(user.getBio());

        // Salva no banco
        User createdUser = ur.save(userToSave);

        // Retorna um DTO desse usuário salvo
        UserDTOOutput userToReturn = new UserDTOOutput();
        userToReturn.setId(createdUser.getId());
        userToReturn.setUsername(createdUser.getUsername());
        userToReturn.setEmail(createdUser.getEmail());
        userToReturn.setDisplayName(createdUser.getDisplayName());
        userToReturn.setAvatarUrl(createdUser.getAvatarUrl());
        userToReturn.setBio(createdUser.getBio());

        return userToReturn;
    }
}
