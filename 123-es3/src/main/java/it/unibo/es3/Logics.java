package it.unibo.es3;

public interface Logics {

    /**
     * 
     * @param coord
     * @return
     */
    public boolean isActive(Pair<Integer,Integer> coord);

    /**
     * 
     */
    public void expandActives();

    /**
     * 
     * @return
     */
    public boolean quit();

}
