package com.boxuegu.domain;

import java.util.List;

public class PageBean<T> {
	private int pageNum;
	private int totalPage;
	private int totalCount;
	private int currentCount;
	private List<T> currentContent;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	public List<T> getCurrentContent() {
		return currentContent;
	}
	public void setCurrentContent(List<T> currentContent) {
		this.currentContent = currentContent;
	}
	
}
