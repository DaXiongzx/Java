package org.lanqiao.entity;

public class Login {
	private int id;
	private String uname;
	private String upwd;
	public Login() {

	}
	public Login( String uname, String upwd) {
		super();
		this.uname = uname;
		this.upwd = upwd;
	}
	public Login(int id, String uname, String upwd) {
		super();
		id = id;
		this.uname = uname;
		this.upwd = upwd;
	}
	
	public int getid() {
		return id;
	}
	public void setid(int id) {
		id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

}
