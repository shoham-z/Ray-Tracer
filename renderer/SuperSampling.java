package renderer;

import primitives.*;

import java.util.LinkedList;
import java.util.List;

import static primitives.Util.alignZero;

/**
 * This class represents super-sampling through rectangular grid
 */
public class SuperSampling {
    /**
     * Width\Height of the grid
     */
    public int size = 1;

    /**
     * Setter for size of super-sampling
     *
     * @param size Width\Height of the grid
     * @return This SuperSampling object
     */
    public SuperSampling setSize(int size) {
        this.size = size;
        return this;
    }

    /**
     * Constructs all the super-sampling rays through the pixel
     * @param height Height of the target area
     * @param width Width of the target area
     * @param source Source point
     * @param gridCenter Center point of the area
     * @param vUp Up direction of the area
     * @param vRight Right direction of the area
     * @return List of the rays constructed through the target area
     */
    public Ray[][] constructRaysThroughGrid(double height, double width, Point source, Point gridCenter, Vector vUp, Vector vRight) {
        Ray[][] rays = new Ray[this.size][this.size];
        double xJ;
        double yI = height / (2 * this.size) - (height / 2);
        Point destination;
        for (int i = 0; i < this.size; i++) {
            xJ = width / (2 * this.size) - (width / 2);
            for (int j = 0; j < this.size; j++) {
                destination = gridCenter;
                if (xJ != 0) destination = destination.add(vRight.scale(xJ));
                if (yI != 0) destination = destination.add(vUp.scale(yI));
                rays[i][j]=(new Ray(source, destination.subtract(source)));
                xJ = alignZero(xJ + width / this.size);
                if (xJ > (width / 2))
                    xJ = -width / (2 * this.size);
            }
            yI = alignZero(yI + height / this.size);
            if (yI > (height / 2))
                yI = -height / (2 * this.size);
        }
        return rays;
    }

}
