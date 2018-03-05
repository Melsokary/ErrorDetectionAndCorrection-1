
public class Main {

	public static void main(String[] args) {
		int rows = 5;
		int columns = 6;
		int[] originalData = DataCreation.createData(rows * columns);
		int[][] originalDataMatrix = ChangeToMatrix.convertToMatrix(originalData, rows, columns);
		System.out.println("");
		int[][] controlBits = CreateControlBits.createControlBits(originalDataMatrix);
		int[] corruptedData = CorruptData.changeData(originalData, 0.3);
		int[][] corruptedDataMatrix = ChangeToMatrix.convertToMatrix(corruptedData, rows, columns);
	}

}
