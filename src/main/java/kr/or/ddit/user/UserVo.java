package kr.or.ddit.user;

import java.util.Date;

public class UserVo {
	private String userId;
	private String name;
	private String alias;
	private Date bitrh;
	
	public UserVo() {
	
	}
	
	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", name=" + name + ", alias="
				+ alias + ", bitrh=" + bitrh + "]";
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Date getBitrh() {
		return bitrh;
	}
	public void setBitrh(Date bitrh) {
		this.bitrh = bitrh;
	}
	
	public UserVo(String userId, String name, String alias, Date bitrh) {
		super();
		this.userId = userId;
		this.name = name;
		this.alias = alias;
		this.bitrh = bitrh;
	}
	
	
}
