package com.social_mongo_graphql.social;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.social_mongo_graphql.social.DTO.CreateUserInput;
import com.social_mongo_graphql.social.DTO.UserDTOOutput;
import com.social_mongo_graphql.social.model.Post;
import com.social_mongo_graphql.social.model.User;
import com.social_mongo_graphql.social.repository.PostRepository;
import com.social_mongo_graphql.social.repository.UserRepository;
import com.social_mongo_graphql.social.service.PostService;
import com.social_mongo_graphql.social.service.UserService;

@SpringBootTest
class SocialApplicationTests {

	@Autowired
	private UserService us;

	@Autowired
	private PostService ps;

	@Autowired
	private UserRepository ur;

	@Autowired
	private PostRepository pr;

	@BeforeEach
    void setup() {
        ur.deleteAll(); // limpa dados antes de cada teste
		pr.deleteAll(); // limpa dados antes de cada teste

		CreateUserInput usuario = new CreateUserInput();

		usuario.setUsername("Rafael");
		usuario.setDisplayName("Rafael");
		usuario.setEmail("rafaelnargolo@outlook.com");
		usuario.setPassword("12345");

		UserDTOOutput usuarioCriado = us.createUser(usuario);

		assertNotNull(usuarioCriado.getId());
        assertEquals("Rafael", usuarioCriado.getUsername());
        assertEquals("rafaelnargolo@outlook.com", usuarioCriado.getEmail());

		User u = ur.findByUsername("Rafael").get();

		Post post = new Post();
		post.setAuthorId(u.getId());
		post.setContent("Primeiro post de exemplo");
		post.setMediaUrls(List.of("https://plus.unsplash.com/premium_photo-1680157072373-f180488fd8ae?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&q=80&w=681"));

		Post postCriado = pr.save(post);

		assertNotNull(postCriado.getId());
		assertEquals("Primeiro post de exemplo", postCriado.getContent());
    }

	@Test
	void darLike() {
		User u = ur.findByUsername("Rafael").get();
		String postId = pr.findAll().get(0).getId();
		Boolean likedPost = ps.likePost(postId, u.getId());
		assertEquals(true, likedPost);
	}
}
