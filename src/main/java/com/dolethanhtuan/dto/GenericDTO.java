package com.dolethanhtuan.dto;

import java.util.Date;

public class GenericDTO {
	private Long id;
	private String createBy;
	private Date createDate;
	private String modifiedBy;
	private Date modifiedDate;
	public GenericDTO() {
	}
	public GenericDTO(long id, String createBy, Date createDate, String modifiedBy, Date modifiedDate) {
		this.id = id;
		this.createBy = createBy;
		this.createDate = createDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}
	public GenericDTO(String createBy, Date createDate, String modifiedBy, Date modifiedDate) {
		this.createBy = createBy;
		this.createDate = createDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
}
