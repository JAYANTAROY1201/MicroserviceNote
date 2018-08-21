package com.todo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.todo.model.Note;

/**
 * purpose:Elastic repository for Note
 * 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 30/07/18
 */

public interface INoteElasticRepository extends ElasticsearchRepository<Note, String> {
	/**
	 * This method is designed for find note by author id
	 * @param userId
	 * @return list of note(s)
	 */
	public List<Note> findByAuthorId(String userId);
//	public List<Note> findById(String Id);
	/**
	 * This method is designed for find note by note id and author id
	 * @param userId, authorId
	 * @return Optional type note(s)
	 */
	public Optional<Note> findByIdAndAuthorId(String id,String authorId);
	/**
	 * This method is designed for find note by user id and label id
	 * @param userId, labelId
	 * @return list of note(s)
	 */
	public List<Note> findByAuthorIdAndLabel(String userId,String labelId);
}
