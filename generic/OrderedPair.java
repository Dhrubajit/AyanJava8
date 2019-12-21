package generic;

public class OrderedPair<K,V> implements Pair<K,V> {

	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}

interface Pair<K,V>{
	K getKey();
	V getValue();
}

