package com.dolethanhtuan.dto;

import java.util.List;

public class PageDTO <T>{
	private List<T> list;
	private int index;
	private int limit;
	private int totalPage;
	public PageDTO() {
	}
	public PageDTO(List<T> list, int index, int limit,int totalPage) {
		this.list = list;
		this.index = index;
		this.limit = limit;
		this.totalPage = totalPage;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public List<T> getList() {
		return list;
	}
	
	
}
