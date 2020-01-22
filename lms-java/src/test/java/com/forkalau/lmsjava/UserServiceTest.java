package com.forkalau.lmsjava;

import static org.assertj.core.api.Assertions.assertThat;
import com.forkalau.lmsjava.domain.User;
import com.forkalau.lmsjava.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

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
		assertThat(userService.saveOrUpdateUser(user)).isEqualTo(user);
	}

	@Test
	public void testFilterUserList() {

		User user2 = new User();
		User user3 =new User();
		User user4 =new User();
		User user5 =new User();
		user2.setName("Martin");
		user2.setBarcode("2345677777777777777777");
		user2.setMemberType("Staff");
		user3.setName("Bing");
		user3.setBarcode("2345677777777777777777");
		user3.setMemberType("Staff");
		user5.setName("Bing");
		user5.setBarcode("2345677777777777777777");
		user5.setMemberType("Staff");
		user4.setName("Bing");
		user4.setBarcode("2345677777777777777777");
		user4.setMemberType("Staff");
		List<User> userList = Arrays.asList(user4 , user5, user3, user2);

		assertThat(userService.filterUserList("123456", "Martin", userList)).contains(user2);
	}


	@Test
	public void whenValidEmployee_thenShouldSave()
	{
		userService.saveOrUpdateUser(user);
		Long id = Long.valueOf(1);

		userService.deleteUserByIdAndBarcode(id,"2345677777777777777777");
	}
}
