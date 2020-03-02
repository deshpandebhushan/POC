package com.capgemini.alert.model;

import java.io.Serializable;

public class CreateRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Alert alert;
	private final String format;

	/**
	 * Constructor, value object.
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param format
	 *            format
	 */
	public CreateRequest(Alert alert, String format) {
		this.alert = alert;
		this.format = format;
	}

	/**
	 * @return the request
	 */
	public Alert getAlert() {
		return alert;
	}

	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CreateRequest [alert=" + alert + ", format=" + format + "]";
	}

}
