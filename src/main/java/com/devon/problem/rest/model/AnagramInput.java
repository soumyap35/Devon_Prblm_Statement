package com.devon.problem.rest.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/******************************************************************************
 * Created: 09/18/2021
 * Description: Model class for String anagram input
 * @version 1.0
 * @author Soumya Ranjan Parida
 * 
 *****************************************************************************/
public class AnagramInput {

	@Size(max=9, min=1,message="String size must be > 0 and < 10")
	@Pattern(regexp="[a-z]*", message="String should only contain lowercase English alphabets (a-z)")
	@NotNull
	private String str1;
	
	@Size(max=9, min=1,message="String size must be > 0 and < 10")
	@Pattern(regexp="[a-z]*", message="String should only contain lowercase English alphabets (a-z)")
	@NotNull
	private String str2;

	public String getStr1() {
		return str1;
	}

	public void setStr1(String str1) {
		this.str1 = str1;
	}

	public String getStr2() {
		return str2;
	}

	public void setStr2(String str2) {
		this.str2 = str2;
	}
	
}
