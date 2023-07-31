package com.dolethanhtuan.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "[user]")
public class UserEntity extends GenericEntity{
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String fullname;
	@Column
	private int status;
	@ManyToMany(mappedBy = "users",fetch = FetchType.LAZY)
	private List<RoleEntity> roles = new ArrayList<>();
	
	public UserEntity(String username, String password, String fullname, int status) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.status = status;
	}
	public UserEntity() {
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<RoleEntity> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
	
	
	
	
}
