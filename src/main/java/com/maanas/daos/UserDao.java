package com.maanas.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.maanas.models.User;

@Transactional
public interface UserDao extends JpaRepository<User, Long> {
	
	public List<User> findByNameLike(String name);
}
