package anagram;

import java.util.Arrays;

public class Anagram
{

	public static void main(String[] args)
	{
		System.out.println(isAnagram("Salut", "lutsa"));
		System.out.println(isAnagramBySubstring("Salut", "lutsa"));
		System.out.println(isAnagramBySBDelete("Salut", "lutsa"));
		System.out.println(isAnagramBySorting("Salut", "lutsa"));
		System.out.println(isAnagramByCountAndCompare("Salut", "lutsa"));
	}

	public static boolean isAnagram(String word, String anagram)
	{
		validateInput(word, anagram);
		
		if(word.length()!=anagram.length())
		{
			return false;
		}
		
		word=word.toLowerCase();
		anagram=anagram.toLowerCase();
		
		char[] charsFromWord=word.toCharArray();
		char[] charsFromAnagram=anagram.toCharArray();
		
		for(int i=0; i<charsFromWord.length; i++)
		{
			for(int j=0; j<charsFromAnagram.length; j++)
			{
				if(charsFromWord[i]==charsFromAnagram[j])
				{
					charsFromAnagram[j]=0;
					break;
				}
			}
		}
		
		for(char c:charsFromAnagram)
		{
			if(c!=0)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isAnagramBySubstring(String word, String anagram)
	{
		validateInput(word, anagram);
		
		if(word.length()!=anagram.length())
		{
			return false;
		}
		
		word=word.toLowerCase();
		anagram=anagram.toLowerCase();
		
		char[] charsFromWord=word.toCharArray();
		
		for(char c:charsFromWord)
		{
			int index=anagram.indexOf(c);
			if(index!=-1)
			{
				anagram=anagram.substring(0, index)+anagram.substring(index+1, anagram.length());
			}
			else
			{
				return false;
			}
		}
		return anagram.isEmpty();
	}
	
	public static boolean isAnagramBySBDelete(String word, String anagram)
	{
		validateInput(word, anagram);
		
		if(word.length()!=anagram.length())
		{
			return false;
		}
		
		word=word.toLowerCase();
		anagram=anagram.toLowerCase();
		
		char[] charsFromWord=word.toCharArray();
		StringBuilder sbAnagram=new StringBuilder(anagram);
		
		for(char c:charsFromWord)
		{
			int index=sbAnagram.indexOf(""+c);
			if(index!=-1)
			{
				sbAnagram.deleteCharAt(index);
			}
			else
			{
				return false;
			}
		}
		return sbAnagram.length()==0;
	}
	
	public static boolean isAnagramBySorting(String word, String anagram)
	{
		validateInput(word, anagram);
		
		if(word.length()!=anagram.length())
		{
			return false;
		}
		
		word=word.toLowerCase();
		anagram=anagram.toLowerCase();
		
		char[] charsFromWord=word.toCharArray();
		char[] charsFromAnagram=anagram.toCharArray();
		
		Arrays.sort(charsFromWord);
		Arrays.sort(charsFromAnagram);
		
		return Arrays.equals(charsFromWord, charsFromAnagram);
	}
	
	public static boolean isAnagramByCountAndCompare(String word, String anagram)
	{
		validateInput(word, anagram);
		
		if(word.length()!=anagram.length())
		{
			return false;
		}
		
		word=word.toLowerCase();
		anagram=anagram.toLowerCase();
		
		char[] charsFromWord=word.toCharArray();
		char[] charsFromAnagram=anagram.toCharArray();
		
		int[] wordCount=new int[26];
		int[] anagramCount=new int[26];
		
		for(int i=0; i<charsFromWord.length; i++)
		{
			int position=charsFromWord[i]-'a';
			wordCount[position]=wordCount[position]+1;
		}
		
		for(int i=0; i<charsFromAnagram.length; i++)
		{
			int position=charsFromAnagram[i]-'a';
			anagramCount[position]=anagramCount[position]+1;
		}
		
		for(int i=0; i<26; i++)
		{
			if(wordCount[i]!=anagramCount[i])
			{
				return false;
			}
		}
		
		return true;
	}
	
	private static void validateInput(String word, String anagram)
	{
		if(word==null || anagram==null)
		{
			throw new IllegalArgumentException("Input must not be null.");
		}
	}
}
