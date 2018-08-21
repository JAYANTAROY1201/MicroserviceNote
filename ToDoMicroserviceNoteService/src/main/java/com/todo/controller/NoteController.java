package com.todo.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.todo.exception.NoteReaderException;
import com.todo.model.Label;
import com.todo.model.Note;
import com.todo.model.NoteDTO;
import com.todo.model.NoteInLabelDTO;
import com.todo.services.IGeneralNoteService;
import com.todo.services.IUserProxy;
import com.todo.utility.Messages;

/**
 * purpose:This class is designed to control note activity
 * 
 * @author JAYANTA ROY
 * @version 1.0
 * @since 18/07/18
 */
@RefreshScope
@RestController
@RequestMapping("/todo/note")
public class NoteController {
	public static final Logger logger = LoggerFactory.getLogger(NoteController.class);
	@Autowired
	private IUserProxy userProxy;
	@Autowired
	IGeneralNoteService noteService;
	@Autowired
	Messages messages;

	/**
	 * This method is used to create notes
	 * 
	 * @param title
	 * @param description
	 * @param jwt
	 * @return response entity
	 * @throws NoteReaderException
	 * @throws IOException
	 */
	@RequestMapping(value = "/create_note", method = RequestMethod.POST)
	public ResponseEntity<String> createNote(@RequestBody NoteDTO note, HttpServletRequest request)
			throws NoteReaderException, IOException {

		logger.info("Create note method starts");
		String noteId = noteService.doCreateNote(note, request.getHeader("userId"));

		logger.info("Create note method ends");
		logger.info(messages.get("100"));
		return new ResponseEntity<String>(messages.get("100") + " with note ID: " + noteId, HttpStatus.OK);
	}

	/**
	 * This method is to view all notes that is not archived
	 * 
	 * @param jwt
	 * @return response entity
	 * @throws NoteReaderException
	 */
	@RequestMapping(value = "/view_notes", method = RequestMethod.GET)
	public ResponseEntity<?> viewAll(HttpServletRequest request) throws NoteReaderException {
		logger.info("Read note method starts");
		List<Note> notes = noteService.viewAllNotes(request.getHeader("userId"));

		logger.info("Read note method ends");

		return new ResponseEntity<List<Note>>(notes, HttpStatus.OK);
	}
	
	/**
	 * This method is to view all notes that is not archived
	 * 
	 * @param jwt
	 * @return response entity
	 * @throws NoteReaderException
	 */
	@RequestMapping(value = "/sort_by_name", method = RequestMethod.GET)
	public ResponseEntity<?> sortBytitle(HttpServletRequest request) throws NoteReaderException {
		logger.info("Read note method starts");
		List<Note> notes = noteService.doSortByName(request.getHeader("userId"));

		logger.info("Read note method ends");

		return new ResponseEntity<List<Note>>(notes, HttpStatus.OK);
	}
	
	/**
	 * This method is to view all notes that is not archived
	 * 
	 * @param jwt
	 * @return response entity
	 * @throws NoteReaderException
	 */
	@RequestMapping(value = "/sort_by_date", method = RequestMethod.GET)
	public ResponseEntity<?> sortByDate(HttpServletRequest request) throws NoteReaderException {
		logger.info("Read note method starts");
		List<Note> notes = noteService.doSortByDate(request.getHeader("userId"));

		logger.info("Read note method ends");

		return new ResponseEntity<List<Note>>(notes, HttpStatus.OK);
	}

	/**
	 * This method to open archive
	 * 
	 * @param jwt
	 * @return response entity
	 * @throws NoteReaderException
	 */
	@RequestMapping(value = "/open_archive", method = RequestMethod.POST)
	public ResponseEntity<?> openArchive(HttpServletRequest request) throws NoteReaderException {
		logger.info("Read note method starts");
		List<Note> notes = noteService.doOpenArchive(request.getHeader("userId"));

		logger.info("Read note method ends");

		return new ResponseEntity<List<Note>>(notes, HttpStatus.ACCEPTED);
	}

	/**
	 * @param jwt
	 * @param noteId
	 * @return response entity
	 * @throws NoteReaderException
	 */
	@RequestMapping(value = "/open_note/{noteId}", method = RequestMethod.POST)
	public ResponseEntity<?> openNote(HttpServletRequest request, @PathVariable String noteId)
			throws NoteReaderException {

		logger.info("open note method starts");
		List<Note> notes = noteService.doOpenNote(request.getHeader("userId"), noteId);

		logger.info("Read note method ends");

		return new ResponseEntity<List<Note>>(notes, HttpStatus.ACCEPTED);
	}

	/**
	 * This method is to update notes
	 * 
	 * @param jwt
	 * @param noteId
	 * @param newTitle
	 * @param newDescription
	 * @return response entity
	 * @throws NoteReaderException
	 * @throws IOException
	 */
	@RequestMapping(value = "/update_notes/{noteId}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateNote(HttpServletRequest request, @PathVariable String noteId,
			@RequestBody NoteDTO note) throws NoteReaderException, IOException {
		logger.info("Update note method starts");

		noteService.doUpdateNote(request.getHeader("userId"), noteId, note.getTitle(), note.getDescription());

		logger.info("Update note method ends");
		return new ResponseEntity<String>(messages.get("101") + "", HttpStatus.OK);
	}

	/**
	 * This method is to delete notes
	 * 
	 * @param jwt
	 * @param noteId
	 * @return response entity
	 * @throws NoteReaderException
	 */
	@RequestMapping(value = "/delete_notes/{noteId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteNote(HttpServletRequest request, @PathVariable String noteId)
			throws NoteReaderException {
		logger.info("Deleting note method starts");

		noteService.doDeleteNote(request.getHeader("userId"), noteId);

		logger.info("Delete method ends");
		return new ResponseEntity<String>(messages.get("102") + "", HttpStatus.OK);
	}

	/**
	 * @param jwt
	 * @param noteId
	 * @return response entity
	 * @throws NoteReaderException
	 */
	@RequestMapping(value = "/archive_notes/{noteId}", method = RequestMethod.POST)
	public ResponseEntity<String> archiveNote(HttpServletRequest request, @PathVariable String noteId)
			throws NoteReaderException {
		logger.info("Archive note method starts");

		noteService.doArchive(request.getHeader("userId"), noteId);

		logger.info("Note Archived successfully");
		return new ResponseEntity<String>(messages.get("103") + "", HttpStatus.OK);
	}

	/**
	 * @param jwt
	 * @param noteId
	 * @return response entity
	 * @throws NoteReaderException
	 */
	@RequestMapping(value = "/unarchive_notes/{noteId}", method = RequestMethod.POST)
	public ResponseEntity<String> unArchiveNote(HttpServletRequest request, @PathVariable String noteId)
			throws NoteReaderException {
		logger.info("Archive note method starts");

		noteService.doUnarchive(request.getHeader("userId"), noteId);

		logger.info("Note Archived successfully");
		return new ResponseEntity<String>(messages.get("104") + "", HttpStatus.OK);
	}

	/**
	 * @param jwt
	 * @param noteId
	 * @return response entity
	 * @throws NoteReaderException
	 */
	@PostMapping("/pinned_notes/")
	public ResponseEntity<String> pinnedNote(HttpServletRequest request, @RequestParam String noteId)
			throws NoteReaderException {
		logger.info("Pinned note method starts");

		noteService.doPinned(request.getHeader("userId"), noteId);

		logger.info("Note Archived successfully");
		return new ResponseEntity<String>(messages.get("105") + "", HttpStatus.OK);
	}

	/**
	 * @param jwt
	 * @param noteId
	 * @return response entity
	 * @throws NoteReaderException
	 */
	@RequestMapping(value = "/unpinned_notes/{noteId}", method = RequestMethod.POST)
	public ResponseEntity<String> unPinnedNote(HttpServletRequest request, @PathVariable String noteId)
			throws NoteReaderException {
		logger.info("Uninned note method starts");

		noteService.doUnPinned(request.getHeader("userId"), noteId);

		logger.info("Note unpinned successfully");
		return new ResponseEntity<String>(messages.get("106") + "", HttpStatus.OK);
	}

	/**
	 * @param jwt
	 * @param labelName
	 * @param noteLabel
	 * @return response entity
	 * @throws NoteReaderException
	 */
	@RequestMapping(value = "/add_note_to_label", method = RequestMethod.POST)
	public ResponseEntity<String> addNoteToLabel(HttpServletRequest request, @RequestParam String labelName,
			@RequestBody NoteInLabelDTO noteLabel) throws NoteReaderException {
		logger.info("adding note method starts");
		noteService.addNoteToLabel(request.getHeader("userId"), labelName, noteLabel);

		logger.info("Note added successfully");
		return new ResponseEntity<String>(messages.get("107") + "", HttpStatus.OK);
	}

	/**
	 * @param jwt
	 * @param labelName
	 * @param noteId
	 * @return response entity
	 * @throws NoteReaderException
	 */
	@RequestMapping(value = "/set_label_into_note/{noteId}", method = RequestMethod.POST)
	public ResponseEntity<String> setLabelToExistingNote(HttpServletRequest request, @RequestParam String labelName,
			@PathVariable String noteId) throws NoteReaderException {
		logger.info("adding label method starts");
		noteService.doSetLabel(request.getHeader("userId"), noteId, labelName);
		logger.info("adding label method ends");
		return new ResponseEntity<String>(messages.get("108") + "", HttpStatus.OK);
	}

	/**
	 * @param jwt
	 * @param label
	 * @return
	 * @throws NoteReaderException
	 * @throws ParseException
	 */

	@RequestMapping(value = "/make_new_label", method = RequestMethod.POST)
	public ResponseEntity<String> makeLabel(HttpServletRequest request, @RequestBody Label label)
			throws NoteReaderException, ParseException {
		logger.info("Label making process start");

		noteService.doMakeLabel(request.getHeader("userId"), label);

		logger.info("Label making process end");
		return new ResponseEntity<String>(messages.get("109") + "", HttpStatus.OK);
	}

	/**
	 * @param jwt
	 * @param labelName
	 * @return response entity
	 * @throws NoteReaderException
	 * @throws ParseException
	 */
	@RequestMapping(value = "/show_label", method = RequestMethod.GET)
	public ResponseEntity<?> showLabel(HttpServletRequest request, @RequestParam String labelName)
			throws NoteReaderException, ParseException {
		logger.info("Label searching process start");

		List<Note> noteList = noteService.doSearchNoteFromLabel(request.getHeader("userId"), labelName);
		logger.info("Label seaching process end");
		return new ResponseEntity<List<Note>>(noteList, HttpStatus.ACCEPTED);
	}

	/**
	 * @param jwt
	 * @param dateAndTime
	 * @param noteId
	 * @return response entity
	 * @throws NoteReaderException
	 * @throws ParseException
	 */
	@RequestMapping(value = "/set_reminder/{noteId}", method = RequestMethod.POST)
	public ResponseEntity<String> setReminder(HttpServletRequest request, @RequestParam String dateAndTime,
			@PathVariable String noteId) throws NoteReaderException, ParseException {
		logger.info("setting timer method starts");

		noteService.doSetReminder(request.getHeader("userId"), noteId, dateAndTime);

		logger.info("Note reminder added successfully");
		return new ResponseEntity<String>(messages.get("110") + "", HttpStatus.OK);
	}

	/**
	 * @return
	 */
	@GetMapping("/recieve_rest_template/")
	public ResponseEntity<?> get() {
		ResponseEntity<?> responseEntity = new RestTemplate().getForEntity("http://localhost:8762/todo/user/send",
				String.class);

		return responseEntity;
	}

	/**
	 * @return
	 */
	@GetMapping("/receive_feign-client")
	public String showMessage() {
		String str = userProxy.send();
		return str;
	}

}
