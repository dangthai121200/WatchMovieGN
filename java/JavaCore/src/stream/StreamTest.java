package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(2);
		list.add(7);
		list.add(9);
		list.add(2);

		List<Integer> listtest = list.stream().parallel().map(number -> number * 2).sorted()
				.collect(Collectors.toList());
		System.out.println(listtest);
	}
}
