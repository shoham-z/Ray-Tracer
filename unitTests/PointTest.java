package unitTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;
import static primitives.Util.isZero;

/**
 * Unit tests for primitives.Point class
 * @author Shoham
 */
class PointTest {

    /**
     * Test method for {@link primitives.Point#subtract(primitives.Point)}
     */
    @Test
    void subtract() {
        // ============ Equivalence Partitions Tests ==============

        Point p1 = new Point(1, 2, 3);

        // TC1: makes sure point subtraction works properly
        assertEquals(new Vector(1, 1, 1), new Point(2, 3, 4).subtract(p1),
                "ERROR: Point - Point does not work correctly");
    }

    /**
     * Test method for {@link primitives.Point#add(primitives.Vector)}
     */
    @Test
    void add() {
        // ============ Equivalence Partitions Tests ==============
        Point p1 = new Point(1, 2, 3);

        // TC1: makes sure point + vector works properly
        assertEquals(p1.add(new Vector(-1, -2, -3)), new Point(0, 0, 0),
                "ERROR: Point + Vector does not work correctly");
    }

    /**
     * Test method for {@link primitives.Point#distanceSquared(primitives.Point)}
     */
    @Test
    void distanceSquared() {
        Point p = new Point(1,1,1);
        // ============ Equivalence Partitions Tests ==============

        // EP1: makes sure that point distance squared works when distance is greater than 0
        assertEquals(p.distanceSquared(new Point(0, 0, 0)), 3,
                "EP1: Point distance squared for distance greater than 0 doesn't work");

        // ============ Boundary Value Analysis ================

        // VB1: makes sure that point distance squared works when distance is 0
        assertEquals(0d, p.distanceSquared(p), 0.0000001,
                "VB1: Point distance squared for distance equals 0 doesn't work");
    }

    /**
     * Test method for {@link primitives.Point#distance(primitives.Point)}
     */
    @Test
    void distance() {
        Point p = new Point(0,3,4);
        // ============ Equivalence Partitions Tests ==============

        // TC1: makes sure that point distance works when distance is greater than 0
        assertEquals(p.distance(new Point(0, 0, 0)), 5,
                "ERROR: Point distance for distance greater than 0 doesn't work");

        // ============ Boundary Value Analysis ================

        // TC1: makes sure that point distance works when distance is 0
        assertTrue(isZero(p.distance(p)),
                "ERROR: Point distance for distance equals 0 doesn't work");    }
}