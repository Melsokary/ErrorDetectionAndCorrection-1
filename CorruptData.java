
public class CorruptData {
	public static int[] changeData(int[] originalData, double errorProbablityPerBit)
	{
		int[] corruptedData = new int[originalData.length];
		for (int i = 0; i < originalData.length; i++)
		{
			double bitGetsChanged = Math.random();
			if (bitGetsChanged <= errorProbablityPerBit)
			{
				int newValue = (int) Math.floor(Math.random() * 2);
				corruptedData[i] = newValue;
			}
			else
			{
				corruptedData[i] = originalData[i];
			}
			System.out.print(corruptedData[i]);
		}
		System.out.println("");
		return corruptedData;
	}
}
