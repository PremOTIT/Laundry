package com.cg.dryclean.service;

import com.cg.dryclean.entity.User;
import com.cg.dryclean.exception.RecordNotFoundException;

public interface IUserService {
	public User signIn(User user) throws RecordNotFoundException;

	public User signOut(User user) throws RecordNotFoundException;

	public User changePassword(User user) throws RecordNotFoundException;
}
