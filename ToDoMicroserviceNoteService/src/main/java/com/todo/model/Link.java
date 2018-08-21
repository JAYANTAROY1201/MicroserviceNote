package com.todo.model;

import java.io.Serializable;

/**
 * Purpose: pojo class of link
 * @author JAYANTA ROY
 * @version 1.0
 * @since 11/08/18
 *
 */
public class Link implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String linkTitle;
	private String linkDomainName;
	private String linkImage;
	
	public Link() {
	}

	public String getLinkTitle() {
		return linkTitle;
	}

	public void setLinkTitle(String linkTitle) {
		this.linkTitle = linkTitle;
	}

	public String getLinkDomainName() {
		return linkDomainName;
	}

	public void setLinkDomainName(String linkDomainName) {
		this.linkDomainName = linkDomainName;
	}

	public String getLinkImage() {
		return linkImage;
	}

	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}

	@Override
	public String toString() {
		return "Link [linkTitle=" + linkTitle + ", linkDomainName=" + linkDomainName + ", linkImage=" + linkImage + "]";
	}
}
