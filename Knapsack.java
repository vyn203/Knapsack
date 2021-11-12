import java.util.*;
import java.io.*;

public class Knapsack
{
	public static void main( String[] args ) throws Exception
	{	
		if ( args.length < 1 ) 
		{
			System.out.println("MISSING INPUT FILE ON CMD LINE\n");
			System.exit(0);
		}

		Scanner infile = new Scanner( new File( args[0] ) );

		String[] StrSet = infile.nextLine().split("\\s+"); //seperates first line of textfile into seperate tokens
		int sum = infile.nextInt();
		int[] set = new int[ StrSet.length ]; //initializes int array for possible set

		for( int i=0 ; i<StrSet.length ; ++i )
		{
			int number = Integer.parseInt( StrSet[i] );
			set[ i ] = number; //converts each string token into int and inserts them into set array
		}

		for ( int i=0 ; i<set.length ; ++i )
			System.out.print( set[i] + " " );

		System.out.println( "\n" + sum ); 

		int combinations = subsets( StrSet.length );
		int total;
		String result;
		double number;

		for ( int i = 0; i < combinations; ++i )
		{	
			result = "";
			total = 0;

			for(int bindx = 0; bindx < set.length; ++bindx)
			{
				number = i / subsets( bindx );

				if ( number % 2 == 1 )
				{
					total = total + set[ bindx ];
					result = result + set[ bindx ] + " ";
				}
			}

			if ( total == sum )
				System.out.println( result );
		}
	}

	public static int subsets( int elements ) // n elements produces 2^n subsets 
	{
		int total = 1;

		for ( int power = elements; power > 0; --power )
			total = total * 2;

		return total;
	}
} // END CLASS