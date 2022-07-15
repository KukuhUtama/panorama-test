package org.com.panorama.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.com.panorama.entity.UserEntity;
import org.com.panorama.model.CustomUserDetails;
import org.com.panorama.model.User;
import org.com.panorama.repository.MasterRepository;
import org.com.panorama.repository.UserRepository;
import org.com.panorama.repository.UserTypeRepository;
import org.com.panorama.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{

	
	@Autowired
	private MasterRepository masterRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserTypeRepository userTypeRepository;
	
	private UserEntity userEntity;
	private User user;
	private List<User> listUser;
	
	@Override
	public User getById(Long id) throws Exception {
		return  toModel(userRepository.findById(id).get());
	}

	@Override
	public User save(User model) throws Exception {
		UserEntity parentData = userRepository.save(toEntity(model));
		return toModel(parentData);
	}
	
	@Override
	public List<User> getByUserTypeId(Long parentId) throws Exception {
		return toModelList(userRepository.getByUserTypeId(parentId));
	}

	@Override
	public List<User> getByUserMasterId(Long parentId) throws Exception {
		return toModelList(userRepository.getByUserMasterId(parentId));
	}

	@Override
	public List<User> findAll() throws Exception {
		listUser = new ArrayList<User>();
		try {
			Iterator<UserEntity> iterator = userRepository.findAll().iterator();
			while (iterator.hasNext()) {
				userEntity = iterator.next();
				user = toModel(userEntity);
				listUser.add(user);
			}
		} catch (Exception e) {

		}

		return listUser;
	}
	
	@Override
	public CustomUserDetails loadByUsername(String username) {
		return toCustomModel(userRepository.loadByUsername(username));
	}
	
	private UserEntity toEntity(User model) {
		UserEntity entity = new UserEntity();
		if(model.getId() != null){
			entity = userRepository.findById(model.getId()).get();
			entity.setPassword(model.getPassword());
			entity.setName(model.getName());
			entity.setCreatedBy(model.getCreatedBy());
			entity.setCreatedDate(model.getCreatedDate());
			entity.setModifiedBy(model.getModifiedBy());
			entity.setModifiedDate(model.getModifiedDate());
			entity.setIsActive(model.getIsActive());
			entity.setMasterId(masterRepository.findById(model.getMasterId()).get());
			entity.setUserTypeId(userTypeRepository.findById(model.getUserTypeId()).get());
		} else {
			entity.setPassword(model.getPassword());
			entity.setName(model.getName());
			entity.setCreatedBy(model.getCreatedBy());
			entity.setCreatedDate(model.getCreatedDate());
			entity.setModifiedBy(model.getModifiedBy());
			entity.setModifiedDate(model.getModifiedDate());
			entity.setIsActive(model.getIsActive());
			entity.setMasterId(masterRepository.findById(model.getMasterId()).get());
			entity.setUserTypeId(userTypeRepository.findById(model.getUserTypeId()).get());
		}
		return entity;
	}
	
	
	private User toModel(UserEntity entity) {
		User model = new User();
		
		model.setId(entity.getId());
		model.setPassword(entity.getPassword());
		model.setName(entity.getName());
		model.setCreatedBy(entity.getCreatedBy());
		model.setCreatedDate(entity.getCreatedDate());
		model.setModifiedBy(entity.getModifiedBy());
		model.setModifiedDate(entity.getModifiedDate());
		model.setIsActive(entity.getIsActive());
		model.setMasterId(entity.getMasterId().getId());
		model.setUserTypeId(entity.getUserTypeId().getId());
		return model;
	}
	
	private CustomUserDetails toCustomModel(UserEntity entity) {
		CustomUserDetails model = new CustomUserDetails();
		
		model.setId(entity.getId());
		model.setPassword(entity.getPassword());
		model.setUsername(entity.getName());

		return model;
	}



	private List<User> toModelList(List<UserEntity> entityList) throws Exception {
		List<User> rList = new ArrayList<>();
		for (UserEntity el : entityList) {
			rList.add(toModel(el));
		}
		return rList;
	}



}
