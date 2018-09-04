package com.tts.xiaoliji.intf.base;

public class IntfLongPageResponse extends IntfBaseResponse {
	private long totalCount;
	private long totalPage;
	private long pageNum = 20L;
	private long currentPage;

	public long getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getTotalPage() {
		if ((this.totalPage == 0L) && (this.totalCount != 0L)) {
			this.totalPage = (this.totalCount % this.pageNum == 0L ? this.totalCount / this.pageNum
					: this.totalCount / this.pageNum + 1L);
		}
		return this.totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public long getPageNum() {
		return this.pageNum;
	}

	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
	}

	public long getCurrentPage() {
		return this.currentPage;
	}

	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}
}
