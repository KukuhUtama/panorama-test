package org.com.panorama.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.com.panorama.entity.MasterEntity;
import org.com.panorama.model.Master;
import org.com.panorama.model.User;
import org.com.panorama.repository.MasterRepository;
import org.com.panorama.service.MasterService;
import org.com.panorama.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("masterService")
public class MasterServiceImpl implements MasterService{

	
	@Autowired
	private MasterRepository masterRepository;
	@Autowired
	private UserService userService;

	private MasterEntity masterEntity;
	private Master master;
	private List<Master> listMaster;
	
	@Override
	public Master getById(Long id) throws Exception {
		return toModel(masterRepository.findById(id).get());
	}

	@Override
	public Master save(Master model) throws Exception {
		MasterEntity parentData = masterRepository.save(toEntity(model));
		return toModel(parentData);
	}
	
	@Override
	public List<Master> findAll() {
		listMaster = new ArrayList<Master>();
		try {
			Iterator<MasterEntity> iterator = masterRepository.findAll().iterator();
			while (iterator.hasNext()) {
				masterEntity = iterator.next();
				master = toModel(masterEntity);
				master.setListUser(userService.getByUserMasterId(master.getId()));
				listMaster.add(master);
			}
		} catch (Exception e) {

		}
		return listMaster;
	}
	
	
	private MasterEntity toEntity(Master model) {
		MasterEntity entity = new MasterEntity();
		if(model.getId() != null){
			entity = masterRepository.findById(model.getId()).get();
			entity.setCode(model.getCode());
			entity.setName(model.getName());
			entity.setUrl(model.getUrl());
			entity.setCreatedBy(model.getCreatedBy());
			entity.setCreatedDate(model.getCreatedDate());
			entity.setModifiedBy(model.getModifiedBy());
			entity.setModifiedDate(model.getModifiedDate());
			entity.setIsActive(model.getIsActive());
		} else {
			entity.setCode(model.getCode());
			entity.setName(model.getName());
			entity.setUrl(model.getUrl());
			entity.setCreatedBy(model.getCreatedBy());
			entity.setCreatedDate(model.getCreatedDate());
			entity.setModifiedBy(model.getModifiedBy());
			entity.setModifiedDate(model.getModifiedDate());
			entity.setIsActive(model.getIsActive());
		}
		return entity;
	}
	
	
	private Master toModel(MasterEntity entity) {
		Master model = new Master();
		List<User> childList = new ArrayList<User>();
		
		model.setId(entity.getId());
		model.setCode(entity.getCode());
		model.setName(entity.getName());
		model.setUrl(entity.getUrl());
		model.setCreatedBy(entity.getCreatedBy());
		model.setCreatedDate(entity.getCreatedDate());
		model.setModifiedBy(entity.getModifiedBy());
		model.setModifiedDate(entity.getModifiedDate());
		model.setIsActive(entity.getIsActive());
		model.setListUser(childList);
		
		return model;
	}



}
