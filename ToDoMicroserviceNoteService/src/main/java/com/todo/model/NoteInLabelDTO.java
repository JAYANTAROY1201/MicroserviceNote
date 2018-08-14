package com.todo.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import io.swagger.annotations.ApiModelProperty;

/**
 * purpose: Note Bean to describe properties
 * 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 18/07/18
 */

@Document(collection = "note")
public class NoteInLabelDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@ApiModelProperty(hidden = true)
	private String _id;
	@ApiModelProperty(hidden = true)
	private String authorId;
	private String title;
	private String description;

	private String archive;
	@ApiModelProperty(hidden = true)
	// @DBRef
	@Field("label")
	private List<Label> label;

	private String pinned;
	@ApiModelProperty(hidden = true)
	private String trash;

	public String getTrash() {
		return trash;
	}

	public void setTrash(String trash) {
		this.trash = trash;
	}

	@ApiModelProperty(hidden = true)
	private String dateOfCreation;

	@ApiModelProperty(hidden = true)

	private String lastDateOfModified;

	public NoteInLabelDTO() {
	}

	public String get_id() {
		return _id;
	}

	@Id
	public void set_id(String _id) {
		this._id = _id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
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
		return "Note [_id=" + _id + ", authorId=" + authorId + ", title=" + title + ", description=" + description
				+ ", archive=" + archive + ", label=" + label + ", pinned=" + pinned + ", dateOfCreation="
				+ dateOfCreation + ", lastDateOfModified=" + lastDateOfModified + "]";
	}

}
