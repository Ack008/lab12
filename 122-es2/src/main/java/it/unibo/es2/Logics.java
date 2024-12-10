package it.unibo.es2;

public interface Logics {
    /**
     * 
     * @param x
     * @param y
     * @return
     */
    public boolean getValue(final Pair<Integer, Integer> coord);

    /**
     * 
     * @param x
     * @param y
     * @return
     */
    public boolean quit(final Pair<Integer, Integer> coord);
}
