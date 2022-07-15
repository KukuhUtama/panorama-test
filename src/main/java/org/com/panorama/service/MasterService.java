package org.com.panorama.service;

import java.util.List;

import org.com.panorama.model.Master;

public interface MasterService {
	public Master getById(Long id) throws Exception;
	public Master save(Master model) throws Exception;
	public List<Master> findAll();
}
