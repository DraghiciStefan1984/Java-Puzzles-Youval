package stringreverse;

public class ReverseString
{

	public static void main(String[] args)
	{
		System.out.println(reverseString("abcdefg"));
		System.out.println("============");
		System.out.println(reverseStringCharArray("abcdefg"));
	}

	public static String reverseString(String input)
	{
		StringBuilder sb=new StringBuilder();
		for(int i=input.length()-1; i>=0; i--)
		{
			sb.append(input.charAt(i));
		}
		return sb.toString();
	}
	
	public static String reverseStringCharArray(String input)
	{
		char[] charArray=input.toCharArray();
		int begin=0;
		int end=charArray.length-1;
		char temp;
		
		while(end>begin)
		{
			temp=charArray[begin];
			charArray[begin]=charArray[end];
			charArray[end]=temp;
			end--;
			begin++;
		}
		return new String(charArray);
	}
}
