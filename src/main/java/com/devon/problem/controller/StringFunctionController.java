package com.devon.problem.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devon.problem.exception.AnagramImpossibleException;
import com.devon.problem.rest.model.AnagramInput;
import com.devon.problem.service.IStringFunctionService;

/******************************************************************************
 * Created: 09/18/2021
 * Description: Controller class exposing REST API for String functions
 * @version 1.0
 * @author Soumya Ranjan Parida
 * 
 *****************************************************************************/
@RestController
@RequestMapping("/api/v1/strfunction")
public class StringFunctionController {
	private IStringFunctionService strFuncSvc;	
	
	public StringFunctionController(IStringFunctionService strFuncSvc) {
		this.strFuncSvc = strFuncSvc;
	}

	/**
	 * This method will accept 2 strings in JSON format 
	 * and will return the response as "the minimum number of character deletions
	 * required to make the 2 strings anagrams" in JSON format
	 * 
	 * @param inp - input object in JSON format containing 2 strings
	 * @return
	 * @throws AnagramImpossibleException
	 */
	@PostMapping("/anagram")
	public ResponseEntity<Integer> getMinCharDeletionCount(@Valid @RequestBody AnagramInput inp) 
			throws AnagramImpossibleException {
		
		int result = strFuncSvc.findMinCharDeletionForAnagram(inp.getStr1(), inp.getStr2());
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
}
