package com.forkalau.lmsjava;

import com.forkalau.lmsjava.domain.User;
import com.forkalau.lmsjava.services.UserService;
import com.forkalau.lmsjava.services.middlewares.exceptions.CustomException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class BookServiceTest {

	@Autowired
	private UserService userService;

	User user = new User();
	User user2 = new User();
	User user3 = new User();

	public void setUser1ToDatabase() {

		user.setName("Martin Bing");
		user.setBarcode("2345677777777777777777");
		user.setMemberType("Staff");

	}

	public void setUser2ToDatabase() {

		user2.setName("Martin Bing");
		user2.setBarcode("2345677777777777777777");
		user2.setMemberType("Staff");

	}
	public void setUser3ToDatabase() {

		user3.setName("Martin Bing");
		user3.setMemberType("Staff");

	}


	@Test
	//Successful
	public void testCreateUser1() {
		setUser1ToDatabase();
		assertThat(userService.saveOrUpdateUser(user)).isEqualTo(user);
	}

	@Test
	//already exist
	public void testCreateUser3() {
		setUser1ToDatabase();
		setUser2ToDatabase();
		userService.saveOrUpdateUser(user2);
		Assertions.assertThrows(CustomException.class, ()->{
			userService.saveOrUpdateUser(user);
		});
	}


	@Test
	public void deleteUser()
	{
		userService.saveOrUpdateUser(user);
		Long id = Long.valueOf(1);

		userService.deleteUserByIdAndBarcode(id,"2345677777777777777777");
	}
}
