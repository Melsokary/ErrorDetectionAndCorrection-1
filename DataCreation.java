import java.util.Arrays;

public class DataCreation {
	public static int[] createData(int dataLength)
	{
		int[] originalData = new int[dataLength];
		for (int i = 0; i < originalData.length; i++)
		{
			originalData[i] = (int) Math.floor(Math.random() * 2);
			System.out.print(originalData[i]);
		}
		System.out.println("");
		return originalData;
	}
}
