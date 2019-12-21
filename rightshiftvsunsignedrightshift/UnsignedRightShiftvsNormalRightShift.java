package rightshiftvsunsignedrightshift;

public class UnsignedRightShiftvsNormalRightShift {

	public static void main(String[] args) {
		int negNumber1 = -2; 
		System.out.println(negNumber1 + " Before normal right shift : " + Integer.toBinaryString(negNumber1));
		
		negNumber1 = negNumber1 >> 1; 
		System.out.println(negNumber1 + " After normal right shift : " + Integer.toBinaryString(negNumber1));
		
		int posNumber1 = 2; 
		System.out.println(posNumber1 + " Before normal right shift : " + Integer.toBinaryString(posNumber1));
		
		posNumber1 = posNumber1 >> 1; 
		System.out.println(posNumber1 + " After normal right shift : " + Integer.toBinaryString(posNumber1));
		
		int negNumber = -2; 
		System.out.println(negNumber + " Before unsigned right shift : " + Integer.toBinaryString(negNumber));
		
		negNumber = negNumber >>> 1; 
		System.out.println(negNumber + " After unsigned right shift : " + Integer.toBinaryString(negNumber));
		
		int posNumber = 2; 
		System.out.println(posNumber + " Before unsigned right shift : " + Integer.toBinaryString(posNumber));
		
		posNumber = posNumber >>> 1; 
		System.out.println(posNumber + " After unsigned right shift : " + Integer.toBinaryString(posNumber));

	}

}
