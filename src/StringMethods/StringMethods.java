package StringMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		
		int str1 = s1.length();
		int str2 = s2.length();
		if(str1 > str2)
			return s1;
		else
			return s2;
	}

	
	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {
		if(s.contains("underscores"))
		return s.replaceAll(" ", "_");
		
		return s;
	}

	
	
	
	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		
		String[] last1 = s1.split("");
		String[] last2 = s2.split("");
		String[] last3 = s3.split("");
		
		
		String char1 = null;
		String char2 = null;
		String char3 = null;
		
		String[] abcs = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		
		for (int i = 2; i < last1.length; i++) {
			if(!last1[i].equals(" ") && last1[i - 1].equals(" ") && !last1[i - 2].equals(" ")) {
				char1 = last1[i];
				//System.out.println(char1);
			}

		}
		for (int i = 2; i < last2.length; i++) {

			if(!last2[i].equals(" ") && last2[i - 1].equals(" ") && !last2[i - 2].equals(" ")) {
				char2 = last2[i];
				//System.out.println(char2);

			}

		}
		for (int i = 2; i < last3.length; i++) {

			if(!last3[i].equals(" ") && last3[i - 1].equals(" ") && !last3[i - 2].equals(" ")) {
				char3 = last3[i];
				//System.out.println(char3);

			}
		}
		for (int i = 0; i < abcs.length; i++) {
			if(char1.contains(abcs[i])) {
				//System.err.println(s1.replaceAll(" ", "").substring(0, s1.replaceAll(" ", "").length()-1) + " " + char1);
				return s1.replaceAll(" ", "").substring(0, s1.replaceAll(" ", "").length()-1) + " " + char1;
			}
			if(char2.contains(abcs[i])) {
				//System.err.println(s2.replaceAll(" ", "").substring(0, s2.replaceAll(" ", "").length()-1) + " " + char2);

				return s2.replaceAll(" ", "").substring(0, s2.replaceAll(" ", "").length()-1) + " " + char2;
			}
			if(char3.contains(abcs[i])) {
				///System.err.println(s3.replaceAll(" ", "").substring(0, s3.replaceAll(" ", "").length()-1) + " " + char3);
				return s3.replaceAll(" ", "").substring(0, s3.replaceAll(" ", "").length()-1) + " " + char3;
			}
		}
		
		return null;
		
	}
	
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		String[] numbs = s.split("");
		//ArrayList<Integer> ints = new ArrayList<Integer>();
		int ints = 0;
		for (int i = 0; i < numbs.length; i++) {
			try {
				ints = ints + Integer.parseInt(numbs[i]);
				
			}catch(Exception e) {
				
			}
		}
		return ints;
	}
	
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int numb = 0;
		for (int i = 0; i < s.length(); i++) {
			try {
			if(s.substring(i,i+substring.length()).equals(substring)) {
				numb++;
			}
			}catch(Exception e) {}
		}
		
		return numb;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		return Utilities.encrypt(s.getBytes(), (byte) key);
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		return Utilities.decrypt(s, (byte) key);
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int numb = 0;
		for (int i = 0; i < s.length(); i++) {
			try {
			if(s.substring(i,i+substring.length()).equals(substring) && s.substring(i+substring.length(), i+substring.length()+1).equals(" ")) {
				numb++;
			}
			}catch(Exception e) {}
		}
		
		return numb;
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		
		
		int firstOccur = -1;
		for (int i = 0; i < s.length(); i++) {
			if(s.substring(0,i).contains(substring)) {
				firstOccur = i;
				//System.out.println("Found First @ loc " + i);
				break;
			}
		}
		//System.out.println("Exited first loop, proceding to last loop");

		int lastOccur = -1;
		for (int i = s.length(); i > 0; i--) {
			if(s.substring(i).contains(substring)) {
				lastOccur = i;
				//System.out.println("Found Last @ loc " + i);
				break;
			}
		}
		//System.out.println("Exited last loop, returning " + Math.abs(firstOccur - lastOccur));

		
		return Math.abs(firstOccur - lastOccur);
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		String str = s.replaceAll(" ", "");

		//str.replace("?", "");
		String newStr = "";

		StringBuilder sb = new StringBuilder();

		sb.append(str);
		if(sb.charAt(sb.length()-1) == '?') {
			sb.deleteCharAt(sb.length()-1);
		}
		for (int i = 0; i < sb.length(); i++) {
			try {
				if(sb.charAt(i) == '?') {
					sb.deleteCharAt(i);
				}
				if(sb.charAt(i) == ',') {
					sb.deleteCharAt(i);
				}
				if(sb.charAt(i) == '.') {
					sb.deleteCharAt(i);
				}
				if(sb.charAt(i) == ':') {
					sb.deleteCharAt(i);
				}
			}catch(Exception e) {}
		}
		newStr = sb.toString();
		sb.reverse();
		//System.out.println(sb.toString());
		
		

//		for (int i = str.length(); i > 0; i--) {
//			newStr = newStr + str.charAt(i-1);
//		}
		
		//System.out.println(newStr + " " + str);
		if(newStr.equalsIgnoreCase(sb.toString()))
		return true;
		else
		return false;
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
