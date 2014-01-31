
public class Converter 
{
	// Takes in one long string of the matrix
	// and returns 2d array
	public int[][] convertBody(String string)
	{
		String[] splits = string.split(" ");
		
		int size = (int) Math.sqrt(splits.length);
		
		int[][] intMatrix = new int[size][size];
		
		for(int i = 0; i < intMatrix.length; i++)
		{
			for(int j = 0 ; j < intMatrix.length; j++)
			{
				int asdf = Integer.parseInt(splits[(i*intMatrix.length)+j]);
				intMatrix[i][j] = asdf;
			}
		}
		
		return intMatrix;
	}
	
	public String convertBody(int[][] matrix)
	{
		String convertedArray = "";
		
		for(int i = 0; i < matrix.length; i++)
		{			
			for(int j = 0; j < matrix.length; j++)
			{
				convertedArray += " " + matrix[i][j] + " ";
			}
			convertedArray += "\n";
		}		
		
		padding(convertedArray);
		
		return convertedArray;
	}
	
	public void padding(String string)
	{
		int longestLength = 0;
		
		String[] splits = string.split(" ");
		
		for(String s : splits)
		{
			if(s.length() > longestLength)
			{
				longestLength = s.length();
			}
		}
		
		for(String s : splits)
		{
			
		}
	}
	
	//818-337-8899
}