package map.hashmap;

import java.util.HashMap;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<Integer, String> hashMap = new HashMap<>();
		hashMap.put(null, "1");
		hashMap.put(null, "2");
		hashMap.put(1, "2");
		hashMap.put(1, "3");
		System.out.println(hashMap.toString());
	}
}
