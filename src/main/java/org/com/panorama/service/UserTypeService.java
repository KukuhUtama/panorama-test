package org.com.panorama.service;

import java.util.List;

import org.com.panorama.model.UserType;

public interface UserTypeService {
	public UserType getById(Long id) throws Exception;
	public UserType save(UserType model) throws Exception;
	public List<UserType> findAll();
}
