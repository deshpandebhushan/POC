package com.capgemini.pubsub.model;

/**
 * 
 * @author bdeshpan
 *
 */
public class Payload {
	private Priority priority;
	private String assetId = null;
	private String description = null;

	/**
	 * @return the priority
	 */
	public Priority getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	/**
	 * @return the assetId
	 */
	public String getAssetId() {
		return assetId;
	}

	/**
	 * @param assetId the assetId to set
	 */
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Payload [priority=" + priority + ", assetId=" + assetId + ", description=" + description + "]";
	}

}
