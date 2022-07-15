package org.com.panorama.utility;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = 8226260897348952661L;
	
	private final String token;

	public JwtResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}
}