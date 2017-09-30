package com.companyname.service.exception;

public class ResourceAlreadyExists extends RuntimeException {

	private static final long serialVersionUID = -3622908303966337627L;

	public ResourceAlreadyExists(String message) {
		super(message);
	}

}
