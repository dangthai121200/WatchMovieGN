package collections.set.hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();
		set.add(null);
		set.add(1);
		set.add(1);
		set.add(2);
		System.out.println(set.toString());

	}
}
