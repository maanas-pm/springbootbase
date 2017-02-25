package com.maanas.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.maanas.models.Class;

@Transactional
public interface ClassDao extends JpaRepository<Class, Long> {
	
	public List<Class> findByName(String name);
}
