package org.com.panorama.controller;

import java.util.List;

import org.com.panorama.model.Master;
import org.com.panorama.service.MasterService;
import org.com.panorama.utility.JedisUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/master")
public class MasterController {


	@Autowired
	private MasterService masterService;
	private String key="";
	private JedisUtility jedisUtility;
	private ObjectMapper objectMapper;
	private String jsonString="";
	private List<Master> listMaster;

	@GetMapping("/get-list.html")
	public ResponseEntity<List<Master>> getListMaster() {
		try {
			jedisUtility = new JedisUtility();
			key = "MASTER-LIST";
			objectMapper = new ObjectMapper();

			if (jedisUtility.get(key) == null || "".equals(jedisUtility.get(key))) {
				listMaster = masterService.findAll();
				jsonString = objectMapper.writeValueAsString(listMaster);
				jedisUtility.save(key, jsonString);
				
			} else {
				jsonString = jedisUtility.get(key);
				listMaster = objectMapper.readValue(jsonString, new TypeReference<List<Master>>() {});
	
			}
		} catch (Exception e) {

		}

		return new ResponseEntity<List<Master>>(listMaster, HttpStatus.OK);
	}
}
