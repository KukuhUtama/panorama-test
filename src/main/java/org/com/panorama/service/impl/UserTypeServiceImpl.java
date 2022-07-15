package org.com.panorama.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.com.panorama.entity.UserTypeEntity;
import org.com.panorama.model.User;
import org.com.panorama.model.UserType;
import org.com.panorama.repository.UserTypeRepository;
import org.com.panorama.service.UserService;
import org.com.panorama.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userServiceType")
public class UserTypeServiceImpl implements UserTypeService {

	@Autowired
	private UserTypeRepository userTypeRepository;
	@Autowired
	private UserService userService;
	
	private UserTypeEntity userTypeEntity;
	private UserType userType;
	private List<UserType> listUserType;

	@Override
	public UserType getById(Long id) throws Exception {
		return toModel(userTypeRepository.findById(id).get());
	}

	@Override
	public UserType save(UserType model) throws Exception {
		UserTypeEntity parentData = userTypeRepository.save(toEntity(model));
		return toModel(parentData);
	}
	
	@Override
	public List<UserType> findAll() {
		listUserType = new ArrayList<UserType>();
		try {
			Iterator<UserTypeEntity> iterator = userTypeRepository.findAll().iterator();
			while (iterator.hasNext()) {
				userTypeEntity = iterator.next();
				userType = toModel(userTypeEntity);
				userType.setListUser(userService.getByUserTypeId(userType.getId()));
				listUserType.add(userType);
			}
		} catch (Exception e) {

		}
		return listUserType;
	}


	private UserTypeEntity toEntity(UserType model) {
		UserTypeEntity entity = new UserTypeEntity();
		if (model.getId() != null) {
			entity = userTypeRepository.findById(model.getId()).get();
			entity.setCode(model.getCode());
			entity.setName(model.getName());
			entity.setCreatedBy(model.getCreatedBy());
			entity.setCreatedDate(model.getCreatedDate());
			entity.setModifiedBy(model.getModifiedBy());
			entity.setModifiedDate(model.getModifiedDate());
			entity.setIsActive(model.getIsActive());
		} else {
			entity.setCode(model.getCode());
			entity.setName(model.getName());
			entity.setCreatedBy(model.getCreatedBy());
			entity.setCreatedDate(model.getCreatedDate());
			entity.setModifiedBy(model.getModifiedBy());
			entity.setModifiedDate(model.getModifiedDate());
			entity.setIsActive(model.getIsActive());
		}
		return entity;
	}

	private UserType toModel(UserTypeEntity entity) {
		UserType model = new UserType();
		List<User> childList = new ArrayList<User>();

		model.setId(entity.getId());
		model.setCode(entity.getCode());
		model.setName(entity.getName());
		model.setCreatedBy(entity.getCreatedBy());
		model.setCreatedDate(entity.getCreatedDate());
		model.setModifiedBy(entity.getModifiedBy());
		model.setModifiedDate(entity.getModifiedDate());
		model.setIsActive(entity.getIsActive());
		model.setListUser(childList);

		return model;
	}

}
