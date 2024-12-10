package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogicsImpl implements Logics {

	private final List<Integer> buttonsValues;

	public LogicsImpl(int size) {
		this.buttonsValues = Stream.generate(() -> 0).limit(size).toList();
	}

	@Override
	public int size() {
		return buttonsValues.size();
	}

	@Override
	public List<Integer> values() {
		return Collections.unmodifiableList(buttonsValues);
	}

	@Override
	public List<Boolean> enablings() {
		return buttonsValues.stream().map(i -> i < buttonsValues.size()).toList();
	}

	@Override
	public int hit(int elem) {
		final int value = buttonsValues.get(elem) + 1;
		buttonsValues.set(elem, value);
		return value;
	}

	@Override
	public String result() {
		return buttonsValues.stream()
			.mapToInt(i -> i)
			.mapToObj(Integer::toString)
			.collect(Collectors.joining("|", "<<", ">>"));
		// String result = "<<";
		// for(int i = 0; i < size; i++ ){
		// 	result = result + buttonsValues.get(i);
		// 	if(i != size - 1) {
		// 		result = result + "|";
		// 	}
		// }
		// result = result + ">>";
		// return result;
	}

	@Override
	public boolean toQuit() {
		final var first = buttonsValues.getFirst();
		return first > 0 &&
			buttonsValues.stream().skip(1).allMatch(it -> it == first);
	}
}
