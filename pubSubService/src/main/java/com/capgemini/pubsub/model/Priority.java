package com.capgemini.pubsub.model;

/**
 * 
 * @author bdeshpan
 *
 */
public enum Priority {

	high(1), low(3), medium(2);

	private int priority;

	Priority(int a) {
		this.priority = a;
	}

	public int getPriority() {
		return this.priority;
	}

}
