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
@Table(name = "t_role_user")
public class RoleUserEntity extends CommonEntity implements Serializable {
	private static final long serialVersionUID = 8906842216641755258L;
	
	private Long id;
	
	private UserEntity userId;
	private RoleEntity roleId;
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	public UserEntity getUserId() {
		return userId;
	}
	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	public RoleEntity getRoleId() {
		return roleId;
	}
	public void setRoleId(RoleEntity roleId) {
		this.roleId = roleId;
	}
}
