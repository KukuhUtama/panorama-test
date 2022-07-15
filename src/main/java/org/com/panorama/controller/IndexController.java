package org.com.panorama.controller;

import java.util.Date;

import org.com.panorama.model.Master;
import org.com.panorama.model.User;
import org.com.panorama.model.UserType;
import org.com.panorama.service.MasterService;
import org.com.panorama.service.UserService;
import org.com.panorama.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@Autowired
	private UserTypeService userTypeService;
	@Autowired
	private MasterService masterService;
	@Autowired
	private UserService userService;
	
	private UserType userType1, userType2, userType3;
	private Master master1, master2;
	private User user1, user2, user3, user4;
	
    @GetMapping("/")
    public String main() {
    	try {
    	  	initData();
    	} catch(Exception e) {
    		
    	}
  
        return "index"; 
    }


    /*Init data*/
    private void initData() throws Exception {
    	
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
	    String password = passwordEncoder.encode("Mandiri123");
	    System.out.println(password);
	    
    	 userType1 = new UserType();

    	 userType1.setCode("APP");
    	 userType1.setName("Approver");
    	 userType1.setCreatedBy("System");
    	 userType1.setCreatedDate(new Date());
    	 userType1.setIsActive(true);
    	 userType1 = userTypeService.save(userType1);
    	 
    	 userType2 = new UserType();
    	 userType2.setCode("INP");
    	 userType2.setName("Inputter");
    	 userType2.setCreatedBy("System");
    	 userType2.setCreatedDate(new Date());
    	 userType2.setIsActive(true);
    	 userType2 = userTypeService.save(userType2);
    	 
    	 userType3 = new UserType();
    	 userType3.setCode("ADM");
    	 userType3.setName("Admin");
    	 userType3.setCreatedBy("System");
    	 userType3.setCreatedDate(new Date());
    	 userType3.setIsActive(true);
    	 userType3 = userTypeService.save(userType3);
    	 
    	 master1 = new Master();
    	 master1.setCode("FA");
    	 master1.setName("Feeding Master");
    	 master1.setUrl("/feeding-master.html");
    	 master1.setIsActive(true);
    	 master1.setCreatedDate(new Date());
    	 master1 = masterService.save(master1);
    	 
    	 master2 = new Master();
    	 master2.setCode("CA");
    	 master2.setName("Consuming Master");
    	 master2.setUrl("/consuming-master.html");
    	 master2.setIsActive(true);
    	 master2.setCreatedDate(new Date());
    	 master2 = masterService.save(master2);
    	 
    	 
    	 user1 = new User();
    	 user1.setName("kukuh.utama");
    	 user1.setPassword(passwordEncoder.encode("Klaten123"));
    	 user1.setMasterId(master1.getId());
    	 user1.setUserTypeId(userType1.getId());
    	 user1.setCreatedBy("System");
    	 user1.setCreatedDate(new Date());
    	 user1 = userService.save(user1);
    	 
    	 user2 = new User();
    	 user2.setName("reggia.algiana");
    	 user2.setPassword(passwordEncoder.encode("Klaten123"));
    	 user2.setMasterId(master2.getId());
    	 user2.setUserTypeId(userType2.getId());
    	 user2.setCreatedBy("System");
    	 user2.setCreatedDate(new Date());
    	 user2 = userService.save(user2);
    	 
    	 user3 = new User();
    	 user3.setName("erik.setyadi");
    	 user3.setPassword(passwordEncoder.encode("Klaten123"));
    	 user3.setMasterId(master1.getId());
    	 user3.setUserTypeId(userType3.getId());
    	 user3.setCreatedBy("System");
    	 user3.setCreatedDate(new Date());
    	 user3 = userService.save(user3);
    	 
    	 user4 = new User();
    	 user4.setName("susan.agnes");
    	 user4.setPassword(passwordEncoder.encode("Klaten123"));
    	 user4.setMasterId(master2.getId());
    	 user4.setUserTypeId(userType1.getId());
    	 user4.setCreatedBy("System");
    	 user4.setCreatedDate(new Date());
    	 user4 = userService.save(user4);
    	 
    	 
    }
}
