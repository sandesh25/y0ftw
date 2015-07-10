package com.system.model;

public class Login implements MyType {
	private String username;
	private String token;
	private String lastused;

	public Login() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLastused() {
		return lastused;
	}

	public void setLastused(String lastused) {
		this.lastused = lastused;
	}
}
