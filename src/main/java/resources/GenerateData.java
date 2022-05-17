package resources;

import org.apache.commons.lang3.RandomStringUtils;

public class GenerateData {
	public String generateRandomString(int length){
		  return RandomStringUtils.randomAlphabetic(length);
		 }
	public String generateRandomNumber(int length){
		  return RandomStringUtils.randomNumeric(length);
		 }
		 
	public String generateRandomAlphaNumeric(int length){
		 String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
				    "1234567890";
			String generateRandomName="";
			String temp =RandomStringUtils.random(length, allowedChars);
			generateRandomName = "Cyb_"+ temp.substring(temp.length()-8);
			return generateRandomName;
		  //return RandomStringUtils.randomAlphanumeric(length);
		 }
		 
	public String generateStringWithAllobedSplChars(int length,String allowdSplChrs){
		  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
		    "1234567890" +   //numbers
		    allowdSplChrs;
		  return RandomStringUtils.random(length, allowedChars);
		 }
		 
	public String generateEmail(int length ) {
		  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
		    "1234567890";   //numbers
		  String email="";
		  String temp=RandomStringUtils.random(length,allowedChars);
		  email=temp.substring(0,temp.length()-9)+"@test.org";
		  return email;
		 }
}
