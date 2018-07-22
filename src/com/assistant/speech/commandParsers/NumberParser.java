package com.assistant.speech.commandParsers;

public class NumberParser implements Parser<String, Integer> {

	@Override
	public Integer parse(String toParse) 
	{
		Integer total = new Integer(0);
		String[] nums = toParse.toLowerCase().split(" ");
		Integer parsed = null;
		for(int i=0;i<nums.length;i++)
		{
			parsed = determineInteger(nums[i]);
			if (parsed != null) total = total + parsed;
		}
		
		return total;
	}

	private Integer determineInteger(String s) 
	{
		
		Integer result = null;
		result = determineSingleDigit(s);
		if(result == null)
		{
			result = determineToTwenty(s);
		}
		if(result == null)
		{
			result = determineToAHundred(s);
		}
		
		return result;
	}

	private Integer determineToAHundred(String s) {
		switch(s)
		{
		case "twenty": return 20;
		case "thirty": return 30;
		case "fourty": return 40;
		case "fifty": return 50;
		case "sixty": return 60;
		case "seventy": return 70;
		case "eighty": return 80;
		case "ninety": return 90;
		case "hundred": return 100;
		}
		return null;
	}

	private Integer determineToTwenty(String s) 
	{
		switch(s)
		{
		case "ten": return 10;
		case "eleven": return 11;
		case "twelve": return 12;
		case "thirteen": return 13;
		case "fourteen": return 14;
		case "fifteen": return 15;
		case "sixteen": return 16;
		case "seventeen": return 17;
		case "eighteen": return 18;
		case "nineteen": return 19;
		}
		return null;
	}

	private Integer determineSingleDigit(String s) 
	{
		switch(s)
		{
		case "zero": return 0;
		case "one": return 1;
		case "two": return 2;
		case "three": return 3;
		case "four": return 4;
		case "five": return 5;
		case "six": return 6;
		case "seven": return 7;
		case "eight": return 8;
		case "nine": return 9;
		}
		return null;
	}
	
}
