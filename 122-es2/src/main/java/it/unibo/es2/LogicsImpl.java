package it.unibo.es2;

public class LogicsImpl implements Logics {
    private final String[][] matrix;
    private final int size;
    public LogicsImpl(int size){
        matrix = new String[size][size];
        this.size = size;
    }

    @Override
    public String getText(int x, int y) {
        matrix[y][x] = matrix[y][x] == "*" ? "" : "*";
        return matrix[y][x];
    }

    private boolean checkRow(final int row){
        boolean equal = true;
        String str = matrix[row][0];
        for(final var i : matrix[row]){
            if(i != str){
                equal = false;
            }
        }
        return equal;
    }

    private boolean checkColm(final int colm){
        boolean equal = true;
        String value = matrix[0][colm];
        for(int i = 0; i < size; i++){
            if(matrix[i][colm] != value) {
                equal = false;
            }
        }
        return equal;
    }

    @Override
    public boolean quit(int y, int x) {
        return checkColm(x) || checkRow(y);
    }

}
