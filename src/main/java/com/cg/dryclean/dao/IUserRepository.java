package com.cg.dryclean.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dryclean.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

}
