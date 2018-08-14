package com.todo.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import io.swagger.annotations.ApiModelProperty;

/**
 * purpose: Note Bean to describe properties
 * 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 18/07/18
 */

//@Document(collection = "note")
@Document(indexName = "notemicro", type = "notes")
public class Note implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@ApiModelProperty(hidden = true)
	private String id;
	@ApiModelProperty(hidden = true)
	private String authorId;
	private String title;
	private Description description;
	@ApiModelProperty(hidden = true)
	private String trash;
	private String archive;
	private String pinned;
	@Field("label")
	private List<Label> label;
	// private List<Image> image;

	@ApiModelProperty(hidden = true)
	private String dateOfCreation;

	public String getTrash() {
		return trash;
	}

	public void setTrash(String trash) {
		this.trash = trash;
	}

	@ApiModelProperty(hidden = true)

	private String lastDateOfModified;

	public Note() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public String getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(String dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	public String getLastDateOfModified() {
		return lastDateOfModified;
	}

	public void setLastDateOfModified(String lastDateOfModified) {
		this.lastDateOfModified = lastDateOfModified;
	}

	public String getArchive() {
		return archive;
	}

	public void setArchive(String archive) {
		this.archive = archive;
	}

	public List<Label> getLabel() {
		return label;
	}

	public void setLabel(List<Label> label) {
		this.label = label;
	}

	public String getPinned() {
		return pinned;
	}

	public void setPinned(String pinned) {
		this.pinned = pinned;
	}

	@Override
	public String toString() {
		return "Note [_id=" + id + ", authorId=" + authorId + ", title=" + title + ", description=" + description
				+ ", archive=" + archive + ", label=" + label + ", pinned=" + pinned + ", dateOfCreation="
				+ dateOfCreation + ", lastDateOfModified=" + lastDateOfModified + "]";
	}

}
