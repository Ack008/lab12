package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogicsImpl implements Logics {

	private final int size;
	private final List<Integer> buttonsValues; 
	public LogicsImpl(int size) {
		this.size = size;
		this.buttonsValues = Stream.of(0,0,0,0).collect(Collectors.toList());
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<Integer> values() {
		return buttonsValues.subList(0, size);
	}

	@Override
	public List<Boolean> enablings() {
		return buttonsValues.stream().map(i -> i < size).toList();
	}

	@Override
	public int hit(int elem) {
		final int value = buttonsValues.get(elem) + 1;
		buttonsValues.set(elem, value);
		return value;
	}

	@Override
	public String result() {
		String result = "<<";
		for(int i = 0; i < size; i++ ){
			result = result + buttonsValues.get(i);
			if(i != size - 1) {
				result = result + "|";
			}
		}
		result = result + ">>";
		return result;
	}

	@Override
	public boolean toQuit() {
		boolean quit = true;
		int value = buttonsValues.getFirst();
		for(final int i : buttonsValues){
			if(value != i) {
				quit = false;
			}
		}
		return quit;
	}
}
