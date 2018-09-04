package com.tts.xiaoliji.intf.base.dto;

import java.util.Date;
import java.util.List;

public class PackageVersionDTO {
	private String type;
	private List<PackageVersionUnitDTO> fileList;
	private int versionNo;
	private Date createDate;
	private String valid;

	public List<PackageVersionUnitDTO> getFileList() {
		return this.fileList;
	}

	public void setFileList(List<PackageVersionUnitDTO> fileList) {
		this.fileList = fileList;
	}

	public int getVersionNo() {
		return this.versionNo;
	}

	public void setVersionNo(int versionNo) {
		this.versionNo = versionNo;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getValid() {
		return this.valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
