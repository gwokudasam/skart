package com.spinhighq.skart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spinhighq.skart.dao.UserDAO;
import com.spinhighq.skart.model.User;
import com.spinhighq.skart.service.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	public User getUser(String login) {
		return userDAO.getUser(login);
	}

}


