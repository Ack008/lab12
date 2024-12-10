package it.unibo.es3;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

public class LogicsImpl implements Logics{
    private static final int INITIAL_RANDOM_POINTS = 3;
    public LogicsImpl(final int size){
        final Random rand = new Random();
        for(int i = 0; i < INITIAL_RANDOM_POINTS; i++) {
            final int x = rand.nextInt();
            final int y = rand.nextInt();
        }
    }

    @Override
    public String getText(int pos) {
        return null;
    }
    

}
