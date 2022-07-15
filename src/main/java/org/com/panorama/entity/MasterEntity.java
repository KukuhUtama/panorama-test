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
@Table(name = "t_master")
public class MasterEntity extends CommonEntity implements Serializable{

	private static final long serialVersionUID = -6392441358542087379L;

	private Long id;
	private String code;
	private String name;
	private String url;

	
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
	
	@Column(name = "url", length = 350)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
