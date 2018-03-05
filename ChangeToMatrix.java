
public class ChangeToMatrix {
	public static int[][] convertToMatrix(int[] inputArray, int rows, int columns)
	{
		int positionInArray = 0;
		int[][] dataMatrix = new int[rows][columns];
		for (int i = 0; i < rows; i++)
		{
			System.out.println("");
			for (int j = 0; j < columns; j++)
			{
				dataMatrix[i][j] = inputArray[positionInArray];
				positionInArray++;
				System.out.print(dataMatrix[i][j]);
			}
		}
		return dataMatrix;
	}
}
