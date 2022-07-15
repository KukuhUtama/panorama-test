package org.com.panorama.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class UserEntity extends CommonEntity implements Serializable{
	private static final long serialVersionUID = -5528019274679111130L;

	private Long id;
	
	
	private String name;
	private String password;
	
	
	private MasterEntity masterId;
	private UserTypeEntity userTypeId;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	
	@Column(name = "name", length = 150)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", length = 150)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@ManyToOne
	@JoinColumn(name = "master_id")
	public MasterEntity getMasterId() {
		return masterId;
	}


	public void setMasterId(MasterEntity masterId) {
		this.masterId = masterId;
	}

	@ManyToOne
	@JoinColumn(name = "user_type_id")
	public UserTypeEntity getUserTypeId() {
		return userTypeId;
	}


	public void setUserTypeId(UserTypeEntity userTypeId) {
		this.userTypeId = userTypeId;
	}
	
}
