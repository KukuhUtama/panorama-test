package org.com.panorama.controller;

import java.util.List;

import org.com.panorama.model.User;
import org.com.panorama.service.UserService;
import org.com.panorama.utility.JedisUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	private String key="";
	private JedisUtility jedisUtility;
	private ObjectMapper objectMapper;
	private String jsonString="";
	private User user;
	private List<User> listUser;
	
	@GetMapping("/get-list.html")
	public ResponseEntity<List<User>> getListUserType(){
		try {
			jedisUtility = new JedisUtility();
			key = "USER-LIST";
			objectMapper = new ObjectMapper();
			
			if(jedisUtility.get(key) == null || "".equals(jedisUtility.get(key)) ) {
				listUser = userService.findAll();
				jsonString = objectMapper.writeValueAsString(listUser);
				jedisUtility.save(key, jsonString);
			} else {
				jsonString = jedisUtility.get(key);
				listUser = objectMapper.readValue(jsonString, new TypeReference<List<User>>(){});
			}
			
		} catch(Exception e) {
			
		}
		return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
	}
	
	@GetMapping("/get-by-id.html")
	public ResponseEntity<User> getUserById(@RequestParam(required = true)Integer Id){
		try{
			jedisUtility = new JedisUtility();
			key = "USER-ID";
			objectMapper = new ObjectMapper();
			if(jedisUtility.get(key) == null || "".equals(jedisUtility.get(key)) ) {
				user = userService.getById(Id.longValue());
				jsonString = objectMapper.writeValueAsString(user);
				jedisUtility.save(key, jsonString);
			} else {
				jsonString = jedisUtility.get(key);
				user = objectMapper.readValue(jsonString, new TypeReference<User>(){});
			}
			
		} catch(Exception e) {
			
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	
	
}
