package it.unibo.es2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class LogicsImpl implements Logics {
    private List<List<Boolean>> matrices;
    public LogicsImpl(final int size){
        matrices = new ArrayList<>();
        for(int i = 0; i < size; i++){
            List<Boolean> addedList = new ArrayList<>();
            for(int j = 0; j < size; j++){
                addedList.add(false);
            }
            matrices.add(addedList);
        }
    }

    @Override
    public boolean getValue(final Pair<Integer, Integer> coord){
        List<Boolean> newList = matrices.get(coord.getY());
        newList.set(coord.getX(), !newList.get(coord.getX()));
        matrices.set(coord.getY(), newList);
        return matrices.get(coord.getY()).get(coord.getX());
    }

    private boolean checkRow(final int row){
        final boolean value = matrices.get(0).get(row);
        return value != false && matrices.stream().map(i -> i.get(row)).allMatch(j -> j == value);
    }

    private boolean checkColm(final int colm){
        final boolean value = matrices.get(colm).get(0);
        return value != false && matrices.get(colm).stream().allMatch(i -> i == value);
    }

    @Override
    public boolean quit(final Pair<Integer, Integer> coord) {
        return checkColm(coord.getY()) || checkRow(coord.getX());
    }

}
