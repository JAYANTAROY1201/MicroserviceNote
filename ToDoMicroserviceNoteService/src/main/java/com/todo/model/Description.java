package com.todo.model;

import java.io.Serializable;
import java.util.List;

/**
 * Purpose: Description class to to declare note description either in simple string
 * or in link format 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 11/08/18
 *
 */
public class Description implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> simpleDescription;
	private List<Link> linkDescription;

	public Description() {
	}

	/**
	 * This method is designed for get simple description
	 * @return list of string
	 */
	public List<String> getSimpleDescription() {
		return simpleDescription;
	}

	/**
	 * This method is designed for set simple description
	 * @param list
	 */
	public void setSimpleDescription(List<String> simpleDescription) {
		this.simpleDescription = simpleDescription;
	}

	/**
	 * This method is designed for get linked description
	 * @return list of link
	 */
	public List<Link> getLinkDescription() {
		return linkDescription;
	}

	/**
	 * This method is designed for set linked description
	 * @param list of link
	 */
	public void setLinkDescription(List<Link> linkDescription) {
		this.linkDescription = linkDescription;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Description [description=" + simpleDescription + ", linkDescription=" + linkDescription + "]";
	}

}
