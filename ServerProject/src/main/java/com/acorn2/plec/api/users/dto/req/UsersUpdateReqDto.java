package com.acorn2.plec.api.users.dto.req;

public class UsersUpdateReqDto {
	private String lecUserId;
	private String userEmail;
	private String userPhone;
	private String profileNum;

	public UsersUpdateReqDto() {}

	public UsersUpdateReqDto(String lecUserId, String userEmail, String userPhone, String profileNum) {
		super();
		this.lecUserId = lecUserId;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.profileNum = profileNum;
	}

	public String getLecUserId() {
		return lecUserId;
	}

	public void setLecUserId(String lecUserId) {
		this.lecUserId = lecUserId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getProfileNum() {
		return profileNum;
	}

	public void setProfileNum(String profileNum) {
		this.profileNum = profileNum;
	}
}
