package stringreverse;

import java.util.HashSet;
import java.util.Set;

public class Anagram
{

	public static void main(String[] args)
	{

	}

	public static boolean isAnagram(String one, String two)
	{
		if(one!=two)
		{
			return false;
		}
		else if(one.length()!=two.length())
		{
			return false;
		}
		else if(one.length()<=1 || two.length()<=1)
		{
			return false;
		}
		Set<String> seen=new HashSet<>();
		return true;
	}
}
