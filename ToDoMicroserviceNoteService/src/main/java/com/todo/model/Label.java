package com.todo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;

//@Document(collection = "label")
/**
 * purpose: Label bean class to define label properties
 * 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 10/07/18
 */
@Document(indexName = "labelmicro", type = "labels")
public class Label implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@ApiModelProperty(hidden = true)
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	private String id;

	private String labelName;
	// @DBRef
	// @Field("note")
	@ApiModelProperty(hidden = true)
	private String noteId;
	@ApiModelProperty(hidden = true)
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Label() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getNoteId() {
		return noteId;
	}

	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}

	@Override
	public String toString() {
		return "Label [labelId=" + id + ", labelName=" + labelName + ", noteId=" + noteId + "]";
	}

}
