package org.com.panorama.controller;

import java.util.List;

import org.com.panorama.model.UserType;
import org.com.panorama.service.UserTypeService;
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
@RequestMapping(value = "/user-type")
public class UserTypeController {


	@Autowired
	private UserTypeService userTypeService;
	private String key="";
	private JedisUtility jedisUtility;
	private ObjectMapper objectMapper;
	private String jsonString="";
	private List<UserType> listUserType;
	
	@GetMapping("/get-list.html")
	public ResponseEntity<List<UserType>> getListUserType(){
		try {
			jedisUtility = new JedisUtility();
			key = "USERTYPE-LIST";
			objectMapper = new ObjectMapper();
			
			if (jedisUtility.get(key) == null || "".equals(jedisUtility.get(key))) {
				listUserType = userTypeService.findAll();
				jsonString = objectMapper.writeValueAsString(listUserType);
				jedisUtility.save(key, jsonString);
				
			} else {
				jsonString = jedisUtility.get(key);
				listUserType = objectMapper.readValue(jsonString, new TypeReference<List<UserType>>() {});
			}
		} catch (Exception e) {

		}
		
		return new ResponseEntity<List<UserType>>(listUserType, HttpStatus.OK);
	}
}
