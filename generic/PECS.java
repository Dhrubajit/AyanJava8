package generic;

import java.util.ArrayList;
import java.util.List;

class PECS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Fruit> basket = new ArrayList<>();
		basket.add(new Apple());
		basket.add(new Fruit());
		Apple app = (Apple)basket.get(1);
		
		/*List<? extends Fruit> newBasket1 = basket;
		newBasket1.get(0);
		newBasket1.add(new Apple());*/
		
		Fruit apple = new Fruit();
		List<String> list = new ArrayList<String>();
 		apple.understand(new ArrayList<Integer>());
	}

}


class Fruit extends Apple<Number>{
	
	
}

class Apple<T> {
	
	
}

