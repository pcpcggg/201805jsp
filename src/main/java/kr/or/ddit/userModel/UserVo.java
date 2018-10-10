package kr.or.ddit.userModel;

import java.util.Date;

public class UserVo {
	private String userId;
	private String name;
	private String pass;
	private String addr1;
	private String addr2;
	private String zipcd;
	private Date birth;
	private String eamil;
	private String tel;
	private String profile;
	
	
	
	
	public UserVo() {
		super();
		
	}

	public UserVo(String userId, String name, String pass, String addr1,
			String addr2, String zipcd, Date birth, String eamil, String tel,
			String profile) {
		super();
		this.userId = userId;
		this.name = name;
		this.pass = pass;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.zipcd = zipcd;
		this.birth = birth;
		this.eamil = eamil;
		this.tel = tel;
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", name=" + name + ", pass=" + pass
				+ ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcd=" + zipcd
				+ ", birth=" + birth + ", eamil=" + eamil + ", tel=" + tel
				+ ", profile=" + profile + "]";
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getZipcd() {
		return zipcd;
	}
	public void setZipcd(String zipcd) {
		this.zipcd = zipcd;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	
	
}
