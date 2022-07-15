package org.com.panorama.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "t_role")
public class RoleEntity extends CommonEntity implements Serializable{
	private static final long serialVersionUID = -2605579124651092426L;
	
	private Long id;
	private String code;
	private String name;
	private String desc;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name = "code", nullable = false, unique = true)	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	

	@Column(name = "name", length = 150)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	@Column(name = "description", length = 150)
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
