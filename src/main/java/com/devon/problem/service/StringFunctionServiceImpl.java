package com.devon.problem.service;

import org.springframework.stereotype.Service;

import com.devon.problem.exception.AnagramImpossibleException;

/******************************************************************************
 * Created: 09/18/2021
 * Description: Service Impl class for String functions
 * @version 1.0
 * @author Soumya Ranjan Parida
 * 
 *****************************************************************************/
@Service
public class StringFunctionServiceImpl implements IStringFunctionService{

	/**
	 * This method will accept 2 strings
	 * and will return "the minimum number of character deletions
	 * required to make the 2 strings anagrams"
	 * 
	 * @param inp1
	 * @param inp2
	 * @return
	 * @throws AnagramImpossibleException
	 */
	@Override
	public int findMinCharDeletionForAnagram(String inp1, String inp2) throws AnagramImpossibleException {
		int commonCharCount=0;
		String tempHolder2 = inp2;
		int len2 = tempHolder2.length();
		
		for(Character c : inp1.toCharArray()) {
			tempHolder2 = tempHolder2.replaceFirst(c.toString(), "");
			if(tempHolder2.length() < len2)
				commonCharCount++;
			len2 = tempHolder2.length();
		}
		
		if(commonCharCount == 0)
			throw new AnagramImpossibleException(
					"Inputs have no characters in common and hence cannot be anagrams");
		
		return (inp2.length() + inp1.length()) - (2*commonCharCount);
	}

}
