package com.dolethanhtuan.dto;

public class NewDTO extends GenericDTO{
	private String title;
	private String content;
	private String shortDes;
	private String thumbnail;
	private String categoryCode;
	
	public NewDTO(String title, String content, String shortDes, String thumbnail, String categoryCode) {
		this.title = title;
		this.content = content;
		this.shortDes = shortDes;
		this.thumbnail = thumbnail;
		this.categoryCode = categoryCode;
	}

	public NewDTO() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getShortDes() {
		return shortDes;
	}

	public void setShortDes(String shortDes) {
		this.shortDes = shortDes;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	
	
}
