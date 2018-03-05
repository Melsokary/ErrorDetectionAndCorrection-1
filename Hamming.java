/*
 * This class lets you create parity bits using the Hamming(7,4) algorithm.
 * 
 * The createParityBits method only works with one-dimensional arrays whose length is divisible by four.
 * To ensure this is true, the array can be passed to the adjustLength method,
 * which appends 0 to the array until it is divisible by 4.
 * 
 * The Hamming(7,4) algorithm normally creates a series of 7 bits from 4 bits of data.
 * As this program is intended for simulating error correction of secret data,
 * the data itself may not be transmitted.
 * Therefore, the createParityBits method only returns the added parity bits.
 * 
 * If the parity bits are created from the original data
 * and sent to the person with the possibly corrupted data
 * (Note that  this simulation assumes that the transmission of these bits works perfectly.
 * However, error correction could be applied to the parity bits before the transmission.),
 * the person can use the createParityBits method to create the parity bits from the corrupted data.
 * Then the original parity bits can be compared with the parity bits from the corrupted data.
 * If a mismatch between the two is found, the two arrays of three parity bits can be passed
 * to the correctError method.
 * This method returns the index of the flipped bit in the original data.
 * (Index from 0 to 3, as the parity bits check for an error in data of four bits.)
 * The returned integer can be used to flip the bit at the corresponding index of the data-subarray
 * of four bits.
 * Note that this algorithm can only detect and correct one single bit flip.
 * Thus, the error rate between original and transmitted data needs to be checked
 * using a subset of the data.
 * Only if the error rate is low enough this algorithm can be applied successfully.
 */
public class Hamming {
	public static int[] adjustLength(int[] inputArray)
	{
		int bitsToAdd = 0;
		switch (inputArray.length % 4)
		{
			case 0:
				bitsToAdd = 0;
				break;
			case 1:
				bitsToAdd = 3;
				break;
			case 2:
				bitsToAdd = 2;
				break;
			case 3:
				bitsToAdd = 1;
				break;
		}
		
		int[] adjustedInputArray = new int[inputArray.length + bitsToAdd];
		//System.out.println(adjustedInputArray.length);
		for (int i = 0; i < inputArray.length; i++)
		{
			adjustedInputArray[i] = inputArray[i];
		}
		for (int i = 0; i < bitsToAdd; i++)
		{
			adjustedInputArray[inputArray.length + i] = 0;
		}
		return adjustedInputArray;
	}
	
	public static int[][] createParityBits(int[] inputArray)
	{
		/*int bitsToAdd = 0;
		switch (inputArray.length % 4)
		{
			case 0:
				bitsToAdd = 0;
				break;
			case 1:
				bitsToAdd = 3;
				break;
			case 2:
				bitsToAdd = 2;
				break;
			case 3:
				bitsToAdd = 1;
				break;
		}
		
		int[] adjustedInputArray = new int[inputArray.length + bitsToAdd];
		//System.out.println(adjustedInputArray.length);
		for (int i = 0; i < inputArray.length; i++)
		{
			adjustedInputArray[i] = inputArray[i];
		}
		for (int i = 0; i < bitsToAdd; i++)
		{
			adjustedInputArray[inputArray.length + i] = 0;
		}*/
		/*for (int i = 0; i < adjustedInputArray.length; i++)
		{
			System.out.print(adjustedInputArray[i]);
		}
		System.out.println("");*/
		int[][] outputArray = new int[inputArray.length / 4][3];
		int[][] tempArray = new int[inputArray.length / 4][4];
		
		int inputArrayIndex = 0;
		
		for (int i = 0; i < tempArray.length; i++)
		{
			for (int j = 0; j < tempArray[i].length; j++)
			{
				tempArray[i][j] = inputArray[inputArrayIndex];
				inputArrayIndex++;
			}
		}
		
		for (int i = 0; i < outputArray.length; i++)
		{
			int p1 = (tempArray[i][0] + tempArray[i][1] + tempArray[i][3]) % 2;
			if (p1 == 0)
			{
				outputArray[i][0] = 0;
			}
			else
			{
				outputArray[i][0] = 1;
			}
			
			int p2 = (tempArray[i][0] + tempArray[i][2] + tempArray[i][3]) % 2;
			if (p2 == 0)
			{
				outputArray[i][1] = 0;
			}
			else
			{
				outputArray[i][1] = 1;
			}
			
			int p3 = (tempArray[i][1] + tempArray[i][2] + tempArray[i][3]) % 2;
			if (p3 == 0)
			{
				outputArray[i][2] = 0;
			}
			else
			{
				outputArray[i][2] = 1;
			}
		}
		return outputArray;
	}
	
	public static int correctError(int[] parityBits, int[] parityBitsFromCorruptedData)
	{
		if (parityBits[0] == parityBitsFromCorruptedData[0])
		{
			return 2;
		}
		if (parityBits[1] == parityBitsFromCorruptedData[1])
		{
			return 1;
		}
		if (parityBits[2] == parityBitsFromCorruptedData[2])
		{
			return 0;
		}
		return 3;
	}
}
