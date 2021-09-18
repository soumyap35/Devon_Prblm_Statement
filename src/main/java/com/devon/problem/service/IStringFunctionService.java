package com.devon.problem.service;

import com.devon.problem.exception.AnagramImpossibleException;
/******************************************************************************
 * Created: 09/18/2021
 * Description: Service Interface for String functions
 * @version 1.0
 * @author Soumya Ranjan Parida
 * 
 *****************************************************************************/
public interface IStringFunctionService {
	public int findMinCharDeletionForAnagram(String inp1, String inp2) throws AnagramImpossibleException;
}
