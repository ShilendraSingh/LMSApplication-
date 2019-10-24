package com.hcl.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hcl.lms.dto.BookDto;
import com.hcl.lms.dto.ResponseDto;
import com.hcl.lms.service.LibraryService;



@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })	

/**
 * 
 * @author Shilendra Singh
 * @since   2019-10-17
 * Add the books in Library
 *
 */
public class LibraryController {
	
	
	@Autowired
	private LibraryService libraryService;

	@PostMapping("/book")
	public ResponseEntity<ResponseDto> save(@RequestBody BookDto bookDto) {

		return new ResponseEntity<>(libraryService.save(bookDto), HttpStatus.CREATED);

	
	}
}
