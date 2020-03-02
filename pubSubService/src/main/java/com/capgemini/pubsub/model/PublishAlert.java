package com.capgemini.pubsub.model;

/**
 * 
 * @author bdeshpan
 *
 */

public class PublishAlert {

	private String customerID = null;
	private String location = null;
	private Payload payload = null;
	private boolean isSubscriptionOn;

	/**
	 * @return the customerID
	 */
	public String getCustomerID() {
		return customerID;
	}

	/**
	 * @param customerID
	 *            the customerID to set
	 */
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the payload
	 */
	public Payload getPayload() {
		return payload;
	}

	/**
	 * @param payload
	 *            the payload to set
	 */
	public void setPayload(Payload payload) {
		this.payload = payload;
	}

	/**
	 * @return the isSubscriptionOn
	 */
	public boolean getIsSubscriptionOn() {
		return isSubscriptionOn;
	}

	/**
	 * @param isSubscriptionOn
	 *            the isSubscriptionOn to set
	 */
	public void setSubscriptionOn(boolean isSubscriptionOn) {
		this.isSubscriptionOn = isSubscriptionOn;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PublishAlert [customerID=" + customerID + ", location=" + location + ", payload=" + payload
				+ ", isSubscriptionOn=" + isSubscriptionOn + "]";
	}

}
