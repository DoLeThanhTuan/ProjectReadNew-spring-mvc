package com.dolethanhtuan.dto;

public class UserDTO extends GenericDTO{
	private String fullname;
	private String username;
	private String password;
	private String repeat_password;
	private int status;
	public UserDTO(String fullname, String username, String password, String repeat_password) {
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.repeat_password = repeat_password;
	}
	public UserDTO(String fullname, String username, String password, String repeat_password,int status) {
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.repeat_password = repeat_password;
		this.status = status;
	}
	public UserDTO() {
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
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
	public String getRepeat_password() {
		return repeat_password;
	}
	public void setRepeat_password(String repeat_password) {
		this.repeat_password = repeat_password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
