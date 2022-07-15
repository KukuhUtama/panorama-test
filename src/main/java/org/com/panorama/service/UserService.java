package org.com.panorama.service;

import java.util.List;

import org.com.panorama.model.CustomUserDetails;
import org.com.panorama.model.User;

public interface UserService {
	public User getById(Long id) throws Exception;
	public User save(User model) throws Exception;
	public List<User> getByUserTypeId(Long parentId) throws Exception;
	public List<User> getByUserMasterId(Long parentId) throws Exception;
	public List<User> findAll() throws Exception;
	public CustomUserDetails loadByUsername(String username);

}
