package com.freehoon.web.user.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.freehoon.web.user.dao.UserDAO;
import com.freehoon.web.user.model.UserVO;

@Service
public class UserServiceImpl implements UserService {
	@Inject
	private UserDAO userDAO;

	@Override
	public List<UserVO> getUserList() throws Exception {
		return userDAO.getUserList();
	}

	@Override
	public UserVO getUserInfo(String uid) throws Exception {
		return userDAO.getUserInfo(uid);
	}

	@Override
	public void insertUser(UserVO userVO) throws Exception {
		userDAO.insertUser(userVO);
	}

	@Override
	public void updateUser(UserVO userVO) throws Exception {
		userDAO.updateUser(userVO);
	}

	@Override
	public void deleteUser(String uid) throws Exception {
		userDAO.deleteUser(uid);
	}
}
