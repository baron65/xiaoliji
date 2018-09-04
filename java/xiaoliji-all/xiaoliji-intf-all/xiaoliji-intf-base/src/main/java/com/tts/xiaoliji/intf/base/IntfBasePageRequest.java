package com.tts.xiaoliji.intf.base;

public class IntfBasePageRequest extends IntfBaseRequest {
	private int startIndex;
	private int queryNum = 20;
	private int currentPage;

	public int getStartIndex() {
		if ((this.startIndex == 0) && (this.currentPage != 0)) {
			this.startIndex = ((this.currentPage - 1) * this.queryNum);
		}
		return this.startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public void setStartIndex(String startIndex) {
		this.startIndex = Integer.valueOf(startIndex).intValue();
	}

	public int getQueryNum() {
		return this.queryNum;
	}

	public void setQueryNum(int queryNum) {
		this.queryNum = queryNum;
	}

	public void setQueryNum(String queryNum) {
		this.queryNum = Integer.valueOf(queryNum).intValue();
	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = Integer.valueOf(currentPage).intValue();
	}
}
