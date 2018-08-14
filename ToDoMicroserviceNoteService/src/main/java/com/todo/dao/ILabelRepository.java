package com.todo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.todo.model.Label;

/**
 * Purpose:This interface is designed to provide methods to perform label
 * operation
 * 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 20/07/18
 */
@Repository
public interface ILabelRepository extends MongoRepository<Label, String> {
	
	/**
	 * @param labelName
	 * @return
	 */
	public List<Label> findByLabelName(String labelName);

	/**
	 * @param noteId
	 * @return
	 */
	public Optional<Label>[] findByNoteId(String noteId);

	/**
	 * @param noteId
	 */
	public void deleteByNoteId(String noteId);

	/**
	 * @param labelName
	 */
	public void deleteByLabelName(String labelName);

}
