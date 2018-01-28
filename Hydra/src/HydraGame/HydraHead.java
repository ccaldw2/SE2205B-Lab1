/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HydraGame;

import javafx.scene.shape.Circle;

/**
 *
 * @author Abdelkader
 */
public class HydraHead extends Circle {

    private int headSize;
    private final int gridX;
    private final int gridY;

    public HydraHead(int size, int x, int y) {
        super(10.0);
        this.headSize = size;
        this.gridX = x;
        this.gridY = y;
    }

    public void setHeadSize(int size) {
        this.headSize = size;
    }

    public int getHeadSize() {
        return headSize;
    }

    public int getGridX() {
        return gridX;
    }

    public int getGridY() {
        return gridY;
    }
}
