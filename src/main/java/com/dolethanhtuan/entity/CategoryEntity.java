package com.dolethanhtuan.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "category")
public class CategoryEntity extends GenericEntity{
	@Column
	private String code;
	@Column
	private String name;
	@OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
	private List<NewEntity> news = new ArrayList<>();
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
	
	public List<NewEntity> getNews() {
		return news;
	}
	public void setNews(List<NewEntity> news) {
		this.news = news;
	}
	
	
}
