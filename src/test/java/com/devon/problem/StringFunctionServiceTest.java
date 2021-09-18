package com.devon.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.devon.problem.exception.AnagramImpossibleException;
import com.devon.problem.service.IStringFunctionService;

@SpringBootTest
public class StringFunctionServiceTest {

	@Autowired
	IStringFunctionService stringFunctionSvc;
	
	@Test
	public void testValidInput() throws AnagramImpossibleException {
		int result = stringFunctionSvc.findMinCharDeletionForAnagram("abcde", "abe");
		assertEquals(2, result);
	}
	
	@Test
	public void testImpossibleInput() throws AnagramImpossibleException {
		AnagramImpossibleException ex = assertThrows(AnagramImpossibleException.class, () -> {
			stringFunctionSvc.findMinCharDeletionForAnagram("cdf", "abe");
		});
		
		assertEquals("Inputs have no characters in common and hence cannot be anagrams", ex.getMessage());
	}
}
