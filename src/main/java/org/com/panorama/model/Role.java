package org.com.panorama.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Role implements Serializable{

	private static final long serialVersionUID = 3210602150027809601L;

	private Long id;
	private String code;
	private String name;
	private String desc;
	
	private Date createdDate;
	private String createdBy;
	private Boolean deleted;
	private Date modifiedDate;
    private String modifiedBy;
    
    
	private List<User> listUser;
	private List<Menu> listMenu;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public Boolean getDeleted() {
		return deleted;
	}


	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}


	public Date getModifiedDate() {
		return modifiedDate;
	}


	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	public String getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}


	public List<Menu> getListMenu() {
		return listMenu;
	}


	public void setListMenu(List<Menu> listMenu) {
		this.listMenu = listMenu;
	}
	
}
