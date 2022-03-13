package com.cg.dryclean.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dryclean.dao.IUserRepository;
import com.cg.dryclean.entity.User;
import com.cg.dryclean.exception.RecordNotFoundException;
import com.cg.dryclean.utility.GlobalResources;

@Service("IUserService")
public class IUserServiceImpl implements IUserService {

	@Autowired
	IUserRepository iUserRepository;
	private Logger logger = GlobalResources.getLogger(IUserService.class);

	@Override
	public User signIn(User user) throws RecordNotFoundException {
		String methodName = "signIn()";
		logger.info(methodName + "Called");
		iUserRepository.saveAndFlush(user);
		return user;
	}

	@Override
	public User signOut(User user) throws RecordNotFoundException {
		String methodName = "signOut()";
		logger.info(methodName + "Called");
		User bean = null;
		try {
			bean = iUserRepository.findById(user.getUserId()).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Payment details not found!");
		}
		iUserRepository.deleteById(user.getUserId());
		return bean;
	}

	@Override
	public User changePassword(User user) throws RecordNotFoundException {
		String methodName = "changePassword()";
		logger.info(methodName + "Called");
		User bean = null;
		try {
			bean = iUserRepository.findById(user.getUserId()).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Payment details not found!");
		}
		iUserRepository.saveAndFlush(user);
		return bean;
	}

}