package it.unibo.es3;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class GUI extends JFrame {
    
    private final List<JButton> cells = new ArrayList<>();
    private final Logics logics;
    private final int width;
    public GUI(int width) {
        this.width = width;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70*width, 70*width);
        logics = new LogicsImpl(width);
        JPanel panel = new JPanel(new GridLayout(width,width));
        JPanel canvas = new JPanel(new BorderLayout());
        canvas.add(panel, BorderLayout.CENTER);
        JButton nextFrameButton = new JButton(">");
        canvas.add(nextFrameButton, BorderLayout.SOUTH);
        this.getContentPane().add(canvas);
               
        for (int i=0; i<width; i++){
            for (int j=0; j<width; j++){
                final JButton jb = new JButton(" ");
                this.cells.add(jb);
                panel.add(jb);
            }
        }
        drawGrid();
        /**
         * Handler
         */
        nextFrameButton.addActionListener(e -> {
            logics.expandActives();
            drawGrid();
            if(logics.quit()) {
                System.exit(0);
            }
        });
        this.setVisible(true);
    }

    private void drawGrid() {
        for(final JButton button : cells) {
            button.setText(getButtonText(cells.indexOf(button)));
        }
    }
    private String getButtonText(final int pos) {
        return  getButtonText(new Pair<>(pos % width, pos / width));
    }
    private String getButtonText(final Pair<Integer, Integer> coord){
        return logics.isActive(coord)? "*" : " ";
    }
    
}