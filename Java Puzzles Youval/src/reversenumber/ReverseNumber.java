package reversenumber;

public class ReverseNumber
{

	public static void main(String[] args)
	{
		System.out.println(reverseNumber(3456789));
	}

	public static int reverseNumber(int number)
	{
		if(number<0)
		{
			throw new IllegalArgumentException("Number must be greater than 0.");
		}
		
		int reverse=0;
		int remainder=0;
		
		do
		{
			remainder=number%10;
			reverse=reverse*10+remainder;
			number=number/10;
		}while(number>0);
		
		return reverse;
	}
}
