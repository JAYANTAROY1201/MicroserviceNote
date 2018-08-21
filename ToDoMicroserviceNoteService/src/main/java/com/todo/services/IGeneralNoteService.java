package com.todo.services;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import com.todo.exception.NoteReaderException;
import com.todo.model.Label;
import com.todo.model.Note;
import com.todo.model.NoteDTO;
import com.todo.model.NoteInLabelDTO;

/**
 * purpose: General Note services to set methods
 * 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 17/07/18
 */
public interface IGeneralNoteService {
	/**
	 * @param note
	 * @param authorId
	 * @return 
	 * @throws NoteReaderException
	 * @throws IOException
	 */
	public String doCreateNote(NoteDTO note, String authorId) throws NoteReaderException, IOException;

	/**
	 * @param userID
	 * @return
	 * @throws NoteReaderException
	 */
	public List<Note> viewAllNotes(String userID) throws NoteReaderException;

	/**
	 * @param userId
	 * @param noteId
	 * @param newTitle
	 * @param newDescription
	 * @throws NoteReaderException
	 * @throws IOException 
	 */
	public void doUpdateNote(String userId, String noteId, String newTitle, String newDescription)
			throws NoteReaderException, IOException;

	/**
	 * @param userId
	 * @param noteId
	 * @throws NoteReaderException
	 */
	public void doDeleteNote(String userId, String noteId) throws NoteReaderException;

	/**
	 * @param userID
	 * @return
	 * @throws NoteReaderException
	 */
	public List<Note> doOpenArchive(String userID) throws NoteReaderException;

	/**
	 * @param userID
	 * @param noteId
	 * @return
	 * @throws NoteReaderException
	 */
	public List<Note> doOpenNote(String userID, String noteId) throws NoteReaderException;

	/**
	 * @param userId
	 * @param noteId
	 * @throws NoteReaderException
	 */
	public void doArchive(String userId, String noteId) throws NoteReaderException;

	/**
	 * @param userId
	 * @param noteId
	 * @throws NoteReaderException
	 */
	public void doUnarchive(String userId, String noteId) throws NoteReaderException;

	/**
	 * @param userId
	 * @param noteId
	 * @throws NoteReaderException
	 */
	public void doPinned(String userId, String noteId) throws NoteReaderException;

	/**
	 * @param userId
	 * @param noteId
	 * @throws NoteReaderException
	 */
	public void doUnPinned(String userId, String noteId) throws NoteReaderException;

	/**
	 * @param userId
	 * @param labelName
	 * @param noteLabel
	 * @throws NoteReaderException
	 */
	public void addNoteToLabel(String userId, String labelName, NoteInLabelDTO noteLabel) throws NoteReaderException;

	/**
	 * @param userId
	 * @param noteId
	 * @param labelName
	 * @throws NoteReaderException
	 */
	public void doSetLabel(String userId, String noteId, String labelName) throws NoteReaderException;

	/**
	 * @param userId
	 * @param label
	 * @throws NoteReaderException
	 */
	public void doMakeLabel(String userId, Label label) throws NoteReaderException;

	/**
	 * @param userId
	 * @param labelName
	 * @return
	 */
	public List<Note> doSearchNoteFromLabel(String userId, String labelName);

	/**
	 * @param userId
	 * @param noteId
	 * @param reminderTime
	 * @throws ParseException
	 */
	public void doSetReminder(String userId, String noteId, String reminderTime) throws ParseException;

	/**
	 * @param userId
	 * @param noteId
	 * @throws NoteReaderException
	 */
	public void doDeleteNoteFromTrash(String userId, String noteId) throws NoteReaderException;
	
	/**
	 * This method is designed for sorting notes by title
	 * @param userId
	 * @throws NoteReaderException
	 */
	public List<Note> doSortByName(String userID) throws NoteReaderException;
	/**
	 * This method is designed for sorting notes by date
	 * @param userId
	 * @throws NoteReaderException
	 */
	public List<Note> doSortByDate(String userId);
}
