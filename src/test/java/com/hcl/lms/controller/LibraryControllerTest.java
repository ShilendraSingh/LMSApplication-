package com.hcl.lms.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.hcl.lms.dto.BookDto;
import com.hcl.lms.dto.ResponseDto;
import com.hcl.lms.service.LibraryServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class LibraryControllerTest {
	
	@InjectMocks
	LibraryController libraryController;

	@Mock
	LibraryServiceImpl libraryServiceImpl	;

	MockMvc mockMvc;
	
	BookDto bookDto = null;
	ResponseDto responseDto = null;
	
	@Before
	public void setup() {
		bookDto = new BookDto();
		bookDto.setAuthor("xyz");
		bookDto.setBookName("Java");
		bookDto.setUserId(101);
		
		responseDto =  new ResponseDto();
		responseDto.setBookCode(1010);
		responseDto.setMessage("Added");
		responseDto.setStatusCode(201);
	}
	
	@Test
	public void saveTest() {
		Mockito.when(libraryServiceImpl.save(bookDto)).thenReturn(responseDto);
		ResponseEntity<ResponseDto> actualResult = libraryController.save(bookDto);
		assertEquals(201, actualResult.getStatusCode().value());
	}

}
