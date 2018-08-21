package com.todo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.todo.model.Note;
import java.lang.String;


/**
 * Purpose: 
 * @author JAYANTA ROY
 * @version 1.0
 * @since  01/08/18
 *
 */
public interface INoteRepository extends MongoRepository<Note, String> {
	/**
	 * This method is designed for find note by author id
	 * @param userId
	 * @return list of note(s)
	 */
	public List<Note> findByAuthorId(String userId);
	/**
	 * This method is designed for find note by note id and author id
	 * @param id
	 * @param authorId
	 * @return optional type note(s)
	 */
	public Optional<Note> findByIdAndAuthorId(String id,String authorId);		
	/**
	 * This method is designed for find note by user id and label id
	 * @param authorId
	 * @param labelId
	 * @return list of note(s)
	 */
	@Query(value = "{ 'authorId' : ?0, 'label._id' : ?1 }")
	public List<Note> findByAuthorIdAndLabel(String authorId,String labelId);
}
