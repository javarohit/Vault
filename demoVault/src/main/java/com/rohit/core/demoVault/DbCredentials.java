package com.rohit.core.demoVault;

public class DbCredentials {
	private String dbUserName;
	private String dbPassword;
	public String getDbUserName() {
		return dbUserName;
	}
	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	@Override
	public String toString() {
		return "{Database UserName :"+dbUserName+"} {Database Password :"+dbPassword+"}";
	}
}
