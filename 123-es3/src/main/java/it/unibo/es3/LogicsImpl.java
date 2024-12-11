package it.unibo.es3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

public class LogicsImpl implements Logics{
    private static final int INITIAL_RANDOM_POINTS = 3;
    private final Map<Pair<Integer,Integer>, Boolean> grid;
    private final Set<Pair<Integer,Integer>> actives;
    private final int size;
    public LogicsImpl(final int size){
        this.size = size;
        grid = new HashMap<>();
        actives = new HashSet<>();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                grid.put(new Pair<>(j, i),false);
            }
        }
        final Random rand = new Random();
        for (int i = 0; i < INITIAL_RANDOM_POINTS; i++) {
            var rcoord = new Pair<>(Math.abs(rand.nextInt() % 10), Math.abs(rand.nextInt() % 10));
            while (actives.contains(rcoord)){
                rcoord = new Pair<>(Math.abs(rand.nextInt() % 10), Math.abs(rand.nextInt() % 10));
            }
            actives.add(rcoord);
            grid.replace(rcoord, true);
        }
    }
    
    @Override
    public void expandActives() {
        actives.addAll(
        actives.stream()
            .flatMap(i -> Stream.of(
                new Pair<>(i.getX() + 1,i.getY()),
                new Pair<>(i.getX() + 1,i.getY() + 1),
                new Pair<>(i.getX(), i.getY() + 1),
                new Pair<>(i.getX() - 1, i.getY() + 1),
                new Pair<>(i.getX() - 1, i.getY()),
                new Pair<>(i.getX() - 1, i.getY() - 1),
                new Pair<>(i.getX(), i.getY() - 1),
                new Pair<>(i.getX() + 1, i.getY() - 1)
            ))
            .filter(i -> i.getX() >= 0 && i.getY() >= 0 && i.getX() < size && i.getY() < size)
            .toList()
        );
        actives.forEach(i -> grid.replace(i,true));
    }

    @Override
    public boolean isActive(Pair<Integer,Integer> coord){
        return grid.get(coord);
    }

    @Override
    public boolean quit() {
        return actives.containsAll(grid.entrySet().stream().map(i -> i.getKey()).toList());
    }
    

}
