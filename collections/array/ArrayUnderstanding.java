package collections.array;

public class ArrayUnderstanding {
	public static void main(String[] args) {
		//array declaration and initialization
		int[] arr1 = new int[5];
		int[] arr2 = {1,2,3,4,5};
		int arr3[] = new int[5];
		int arr4[] = {6,7,8,9,10};
		int[]arr5 = new int[5];
		int arr6[] = new int[5];
		
		//array of arrays declaration and initialization
		int[][] arr2dtype1 = new int[4][5];
		int[][] arr2dtype2 = {{1,2,3},{5,6},{8,9,4}};
		int[][] arr2dtype3 = new int[2][];
		arr2dtype3[0] = new int[]{1,2};
		arr2dtype3[1] = new int[3];
		arr2dtype3[2] = new int[6];
		
		int[]arr2dtype4[] = new int[4][5];
		int arr2dtype5[][] = new int[4][5];
	}
}
