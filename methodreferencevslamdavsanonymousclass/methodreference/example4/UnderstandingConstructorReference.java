package methodreferencevslamdavsanonymousclass.methodreference.example4;

//Equivalent Lamda Expression - (args) -> new ClassName(args)
public class UnderstandingConstructorReference {

	public static void main(String[] args) {
		IntPairContainerSupplier supplier = IntPairContainer :: new;
		IntPairContainer container = supplier.supply(3, 5);
		System.out.println(container);
	}

}



@FunctionalInterface
interface IntPairContainerSupplier{
	IntPairContainer supply (int k,int l);
}

class IntPairContainer{
	
	private final int firstArg;
	private final int secondArg;
	
	public IntPairContainer(int i, int j){
		firstArg = i;
		secondArg = j;
	}

	public int getFirstArg() {
		return firstArg;
	}

	public int getSecondArg() {
		return secondArg;
	}

	@Override
	public String toString() {
		return "IntPairContainer [firstArg=" + firstArg + ", secondArg=" + secondArg + "]";
	}
	
	
	
}