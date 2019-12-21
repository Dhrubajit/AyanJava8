package collections.map;

public class HashMapInternal {
	
	private static final int MAXIMUM_CAPACITY = 1<<30;

	public static void main(String[] args) {
		
		System.out.println(Integer.toBinaryString(11));
		System.out.println(tableSizeFor(0));

	}
	
	static final int hash(Object arg) {
		int arg0;
		return arg == null ? 0 : (arg0 = arg.hashCode()) ^ arg0 >>> 16;
	}
	
	static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
