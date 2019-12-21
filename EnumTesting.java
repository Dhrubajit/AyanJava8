
public class EnumTesting{
	public static void main(String[] args) {
		String i = Level.HIGH.abc();
		System.out.println(i);
		
	}
}


enum Level{
	HIGH (2){
		@Override
		String abc() {
			return "2";
		}
		@Override
		public void defaultMethodForAllEnum(){
			System.out.println("defaultMethodForHighEnum");
		}
		public void enumHighHasOwnMethod(){
			System.out.println("enumHighHasOwnMethod");
		}
	},LOW
	
	{
		@Override
		String abc() {
			return "3";
		}
	};	
	
	private Level(){
		System.out.println("default");
	}
	
	private Level(int i){
		System.out.println("ami constructor"+i);
	}
	abstract String abc();
	
	public void defaultMethodForAllEnum(){
		System.out.println("defaultMethodForAllEnum");
	}
	
}