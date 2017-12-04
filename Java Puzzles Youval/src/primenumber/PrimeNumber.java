package primenumber;

public class PrimeNumber
{

	public static void main(String[] args)
	{
		System.out.println(isPrimeNumber(29));
	}

	private static boolean isPrimeNumber(int number)
	{
		if(number<2)
		{
			throw new IllegalArgumentException("Number must be greater than 2");
		}
		
		for(int i=2; i<number; i++)
		{
			if(number%i==0)
			{
				return false;
			}
		}
		return true;
	}
}
