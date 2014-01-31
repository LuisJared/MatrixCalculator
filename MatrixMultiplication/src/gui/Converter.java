package gui;

public class Converter 
{
	// Takes in one long string of the matrix
	// and returns 2d array
	public static int[][] convertBody(String string)
	{
		if(string == null)throw new IllegalArgumentException("string must be null");
		if(string.trim().equals(""))throw new IllegalArgumentException("string must not be empty and must contain at leat one nonspace character");
		
		String[] rows = string.split("\n");
		
		String[][] stringMatrix = new String[rows.length][];
		
		for(int i = 0; i < rows.length; i++){
			stringMatrix[i] = rows[i].split(" ");
		}
		
		for(int i = 0; i < stringMatrix.length; i++){
			if(stringMatrix.length != stringMatrix[i].length)throw new IllegalArgumentException("matrix must be square!");
		}
		
		int[][] matrix = new int[rows.length][rows.length];
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				matrix[i][j] = Integer.parseInt(stringMatrix[i][j]);
			}
		}
		
		return matrix;
	}
	
	public static String convertBody(int[][] matrix){
		if(matrix == null)throw new IllegalArgumentException("matrix must not be null");
		for(int i = 0; i < matrix.length; i++){
			if(matrix.length != matrix[i].length)throw new IllegalArgumentException("matrix must be square!");
		}
		
		
		//do conversions
		int maxSize = 0;
		String[][] values = new String[matrix.length][matrix.length];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix.length; j++){
				values[i][j] = "" + matrix[i][j];
				if(values[i][j].length() > maxSize){
					maxSize = values[i][j].length();
				}
			}
		}
		
		//apply padding and concatenate to final string
		String rv = "";
		for(int i = 0; i < values.length; i++){
			for(int j = 0; j < values.length; j++){
				rv+= pad(values[i][j], maxSize) + " ";
			}
			rv+="\n";
		}
		
		return rv;
	}
	
	private static String pad(String original, int size){
		int requiredSpace = size - original.length();
		
		if(requiredSpace == 0){
			return original;
		}else{
			return createPad(requiredSpace/2 + ((requiredSpace%2 == 0)? 0 :  1)) + original + createPad(requiredSpace/2);
		}
	}
	
	private static String createPad(int size){
		String result = "";
		for(int i = 0; i < size; i++){
			result+= " ";
		}
		return result;
	}
	
//	public String convertBody(int[][] matrix)
//	{
//		String convertedArray = "";
//		
//		for(int i = 0; i < matrix.length; i++)
//		{			
//			for(int j = 0; j < matrix.length; j++)
//			{
//				convertedArray += " " + matrix[i][j] + " ";
//			}
//			convertedArray += "\n";
//		}		
//		
//		padding(convertedArray);
//		
//		return convertedArray;
//	}
	
//	public void padding(String string)
//	{
//		int longestLength = 0;
//		
//		String[] splits = string.split(" ");
//		
//		for(String s : splits)
//		{
//			if(s.length() > longestLength)
//			{
//				longestLength = s.length();
//			}
//		}
//		
//		for(String s : splits)
//		{
//			
//		}
//	}
}