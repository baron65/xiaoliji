package com.tts.xiaoliji.intf.base.user;

public class RMInfo {
	private String rmId;
	private String title;
	private String chineseName;
	private String majorEng;
	private String sex;
	private String city;
	private String entryDate;
	private String duration;
	private String honers;
	private String selfRecomd;
	private String phone;
	private String imageUrl1;
	private String imageUrl2;
	private String imageUrl3;

	public String getRmId() {
		return this.rmId;
	}

	public void setRmId(String rmId) {
		this.rmId = rmId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getChineseName() {
		return this.chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getMajorEng() {
		return this.majorEng;
	}

	public void setMajorEng(String majorEng) {
		this.majorEng = majorEng;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public void setDuration(int duration) {
		this.duration = String.valueOf(duration);
	}

	public String getHoners() {
		return this.honers;
	}

	public void setHoners(String honers) {
		this.honers = honers;
	}

	public String getSelfRecomd() {
		return this.selfRecomd;
	}

	public void setSelfRecomd(String selfRecomd) {
		this.selfRecomd = selfRecomd;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImageUrl1() {
		return this.imageUrl1;
	}

	public void setImageUrl1(String imageUrl1) {
		this.imageUrl1 = imageUrl1;
	}

	public String getImageUrl2() {
		return this.imageUrl2;
	}

	public void setImageUrl2(String imageUrl2) {
		this.imageUrl2 = imageUrl2;
	}

	public String getImageUrl3() {
		return this.imageUrl3;
	}

	public void setImageUrl3(String imageUrl3) {
		this.imageUrl3 = imageUrl3;
	}
}
