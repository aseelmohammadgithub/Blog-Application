package com.starsteam.blog.payloads;

import java.util.Objects;


import lombok.Data;

@Data
public class JwtAuthRequest {

	private String username;
	
	@Override
	public String toString() {
		return "JwtAuthRequest [username=" + username + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JwtAuthRequest other = (JwtAuthRequest) obj;
		return Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String password;

	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
