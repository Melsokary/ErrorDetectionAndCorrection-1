
public class HammingTest {

	public static void main(String[] args) {
		int[] inputData = DataCreation.createData(15);
		inputData = Hamming.adjustLength(inputData);
		int[][] parityBits = Hamming.createParityBits(inputData);
		for (int i = 0; i < parityBits.length; i++)
		{
			for (int j = 0; j < parityBits[i].length; j++)
			{
				System.out.print(parityBits[i][j]);
			}
			System.out.println("");
		}
		int[] corruptedData = CorruptData.changeData(inputData, 0.3);
		int[][] parityBitsFromCorruptedData = Hamming.createParityBits(corruptedData);
		for (int i = 0; i < parityBits.length; i++)
		{
			for (int j = 0; j < parityBitsFromCorruptedData[i].length; j++)
			{
				System.out.print(parityBitsFromCorruptedData[i][j]);
			}
			System.out.println("");
		}
		
		for (int i = 0; i < parityBits.length; i++)
		{
			for (int j = 0; j < parityBits[i].length; j++)
			{
				if (parityBits[i][j] != parityBitsFromCorruptedData[i][j])
				{
					int errorIndex = Hamming.correctError(parityBits[i], parityBitsFromCorruptedData[i]);
					corruptedData[i * 4 + errorIndex] = (corruptedData[i * 4 + errorIndex] + 1) % 2;
					System.out.println("error corrected: " + (i * 4 + errorIndex));
					break;
				}
			}
		}
		
		for (int i = 0; i < corruptedData.length; i++)
		{
			System.out.print(corruptedData[i]);
		}
		System.out.println("");
	}
}