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
@Table(name = "t_role_menu")
public class RoleMenuEntity extends CommonEntity implements Serializable {
	
	private static final long serialVersionUID = -7379374571676435891L;
	
	private Long id;
	
	private MenuEntity menuId;
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
	@JoinColumn(name = "menu_id")
	public MenuEntity getMenuId() {
		return menuId;
	}
	public void setMenuId(MenuEntity menuId) {
		this.menuId = menuId;
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
