package com.todo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.todo.model.Label;

/**
 * purpose: Elastic repository for Label
 * 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 30/07/18
 */

public interface ILabelElasticRepository extends ElasticsearchRepository<Label, String> {

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
