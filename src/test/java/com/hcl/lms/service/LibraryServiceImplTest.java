package com.hcl.lms.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.lms.dto.BookDto;
import com.hcl.lms.dto.ResponseDto;
import com.hcl.lms.repository.LibraryRepository;

@RunWith(MockitoJUnitRunner.class)
public class LibraryServiceImplTest {
	
	@InjectMocks
	LibraryServiceImpl libraryServiceImpl;
	
	@Mock
	LibraryRepository libraryRepository;

	BookDto bookDto = null;
	
	
	@Before
	public void setup() {
		bookDto = new BookDto();
		bookDto.setAuthor("Shilendra");
		bookDto.setBookName("java");
		bookDto.setUserId(1);
	}
	
	@Test
	public void addbookTest() {
		
		Mockito.when(libraryRepository.save(Mockito.anyObject())).thenReturn(Mockito.anyObject());
		
		ResponseDto responseDto = libraryServiceImpl.save(bookDto);
		
		assertEquals("added", responseDto.getMessage());
		
	}
	
}
