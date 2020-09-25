package com.start.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.start.model.User;
import com.start.repository.UserRepositoy;


@Service
@Transactional
public class UserService {

	private final UserRepositoy userRepositoy;
	
	public UserService(UserRepositoy userRepositoy)
	{
		this.userRepositoy = userRepositoy;
	}
	
	public void saveMyUser(User user)
	{
		userRepositoy.save(user);
	}
	
	public List <User> showallUser()
	{
		List<User> users = new ArrayList<User>();
		for(User user: userRepositoy.findAll())
		{
			users.add(user);
		}
		return users;
	}
}
