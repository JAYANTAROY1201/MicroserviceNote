package com.todo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.todo.model.Note;

/**
 * purpose:To implements mongo repository service
 * 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 17/07/18
 */
public interface INoteRepository extends MongoRepository<Note, String> {
	public Optional<Note>[] findByAuthorId(String userId);
	@Query(value = "{ 'authorId' : ?0, 'label._id' : ?1 }")
	public List<Note> findByAuthorIdAndLabel(String authorId,String labelId);
}
