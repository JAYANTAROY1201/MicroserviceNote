package com.todo.dao;

import java.util.List;
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
	public List<Note> findByAuthorId(String userId);

	public List<Note> findByAuthorIdAndLabel(String userId,String labelId);
}
