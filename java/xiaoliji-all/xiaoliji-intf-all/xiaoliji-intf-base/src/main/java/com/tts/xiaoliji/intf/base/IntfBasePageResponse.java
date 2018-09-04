package com.tts.xiaoliji.intf.base;

public class IntfBasePageResponse extends IntfBaseResponse {
	private int totalCount;
	private int totalPage;
	private int pageNum = 20;
	private int currentPage;

	public int getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		if ((this.totalPage == 0) && (this.totalCount != 0)) {
			this.totalPage = (this.totalCount % this.pageNum == 0 ? this.totalCount / this.pageNum
					: this.totalCount / this.pageNum + 1);
		}
		return this.totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNum() {
		return this.pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
