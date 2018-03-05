
public class CreateControlBits {
	public static int[][] createControlBits(int[][] inputMatrix)
	{
		int[][] controlBits = new int[inputMatrix.length][inputMatrix[0].length];
		System.out.println("Control bits:");
		for (int i = 0; i < inputMatrix.length; i++)
		{
			int rowSum = 0;
			for (int j = 0; j < inputMatrix[0].length; j++)
			{
				if (inputMatrix[i][j] == 1)
				{
					rowSum++;
				}
			}
			controlBits[0][i] = rowSum % 2;
			System.out.print(controlBits[0][i]);
		}
		
		System.out.println("");
		
		for (int i = 0; i < inputMatrix[0].length; i++)
		{
			int columnSum = 0;
			for (int j = 0; j < inputMatrix.length; j++)
			{
				if (inputMatrix[j][i] == 1)
				{
					columnSum++;
				}
			}
			controlBits[1][i] = columnSum % 2;
			System.out.print(controlBits[1][i]);
		}
		System.out.println("");
		return controlBits;
	}
}
