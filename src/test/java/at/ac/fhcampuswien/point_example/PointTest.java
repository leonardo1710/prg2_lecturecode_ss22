package at.ac.fhcampuswien.point_example;

import at.ac.fhcampuswien.unittesting.point_example.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PointTest {
    private Point p1;
    private Point p2;

    @BeforeEach
    void setup(){
        p1 = new Point();
        p2 = new Point(0.0,0.0);
    }


    @Test
    @DisplayName("P1 and P2 are on the same position")
    void calcDistance_samePointP1_2_P2() {
        p1.setX(1.0);
        p1.setY(1.0);

        p2.setX(1.0);
        p2.setY(1.0);

        Double actual = p1.calcDistance(p2);
        Double expected = 0.0;
        assertEquals(expected, actual, 0.00001);
    }

    @Test
    @DisplayName("P1 distance to itself")
    void calcDistance_samePointP1_2_P1() {
        p1.setX(1.0);
        p1.setY(1.0);

        Double actual = p1.calcDistance(p1);
        Double expected = 0.0;
        assertEquals(expected,actual, 0.00001);
    }

    @Test
    @DisplayName("P1 distance to p2, p2 is higher")
    void calcDistance_P2higher() {
        p1.setX(1.0);
        p1.setY(1.0);

        p2.setX(2.0);
        p2.setY(2.0);

        Double actual = p1.calcDistance(p2);
        Double expected = 1.414213;
        assertEquals(expected,actual, 0.00001);
    }

    @Test
    @DisplayName("P2 distance to p1, p1 is higher")
    void calcDistance_P1higher() {
        p1.setX(2.0);
        p1.setY(2.0);

        p2.setX(1.0);
        p2.setY(1.0);

        Double actual = p1.calcDistance(p2);
        Double expected = 1.414213;
        assertEquals(expected,actual, 0.00001);
    }

    @Test
    @DisplayName("P1 is negative")
    void calcDistance_P1negative() {
        p1.setX(-1.0);
        p1.setY(-1.0);

        p2.setX(1.0);
        p2.setY(1.0);

        Double actual = p1.calcDistance(p2);
        Double expected = 2.82842;
        assertEquals(expected,actual, 0.00001);
    }


    @Test
    @DisplayName("P1 and p2 are negative")
    void calcDistance_P1negative_P2negative() {
        p1.setX(-1.0);
        p1.setY(-1.0);

        p2.setX(-2.0);
        p2.setY(-2.0);

        Double actual = p1.calcDistance(p2);
        Double expected = 1.414213;
        assertEquals(expected,actual, 0.00001);
    }

    @Test
    @DisplayName("p2 is null")
    void calcDistance_P2_null() {
        p1.setX(1.0);
        p1.setY(1.0);
        assertThrows(IllegalArgumentException.class, () ->  p1.calcDistance(null));
    }

    @Test
    @DisplayName("p1 X null")
    void calcDistance_P1_XisNull() {
        p1.setX(null);
        p1.setY(1.0);
        p2.setX(1.0);
        p2.setY(1.0);
        assertThrows(IllegalArgumentException.class, () ->  p1.calcDistance(p2));
    }

    @Test
    @DisplayName("p1 Y null")
    void calcDistance_P1_YisNull() {
        p1.setX(1.0);
        p1.setY(null);
        p2.setX(1.0);
        p2.setY(1.0);
        assertThrows(IllegalArgumentException.class, () ->  p1.calcDistance(p2));
    }

    @Test
    @DisplayName("p1 X null")
    void calcDistance_P2_XisNull() {
        p1.setX(1.0);
        p1.setY(1.0);
        p2.setX(null);
        p2.setY(1.0);
        assertThrows(IllegalArgumentException.class, () ->  p1.calcDistance(p2));
    }

    @Test
    @DisplayName("p1 Y null")
    void calcDistance_P2_YisNull() {
        p1.setX(1.0);
        p1.setY(1.0);
        p2.setX(1.0);
        p2.setY(null);
        assertThrows(IllegalArgumentException.class, () ->  p1.calcDistance(p2));
    }

    @Test
    void compare_P1equalP2() {
        p1.setX(1.0);
        p1.setY(1.0);

        p2.setX(1.0);
        p2.setY(1.0);

        assertTrue(p1.compare(p2));
    }

    @Test
    void compare_P2equalP1() {
        p1.setX(1.0);
        p1.setY(1.0);

        p2.setX(1.0);
        p2.setY(1.0);

        assertTrue(p2.compare(p1));
    }

    @Test
    void compare_P2Higher() {
        p1.setX(1.0);
        p1.setY(1.0);

        p2.setX(2.0);
        p2.setY(2.0);

        assertFalse(p2.compare(p1));
    }

    @Test
    void compare_P2null() {
        p1.setX(1.0);
        p1.setY(1.0);
        assertThrows(IllegalArgumentException.class, () ->  p1.compare(null));
    }

    @Test
    void compare_P1_Xnull() {
        p1.setX(null);
        p1.setY(1.0);
        p2.setX(2.0);
        p2.setY(2.0);
        assertThrows(IllegalArgumentException.class, () ->  p1.compare(p2));
    }

    @Test
    void compare_P1_Ynull() {
        p1.setX(1.0);
        p1.setY(null);
        p2.setX(2.0);
        p2.setY(2.0);
        assertThrows(IllegalArgumentException.class, () ->  p1.compare(p2));
    }

    @Test
    void compare_P2_Xnull() {
        p1.setX(1.0);
        p1.setY(1.0);
        p2.setX(null);
        p2.setY(2.0);
        assertThrows(IllegalArgumentException.class, () ->  p1.compare(p2));
    }

    @Test
    void compare_P2_Ynull() {
        p1.setX(1.0);
        p1.setY(1.0);
        p2.setX(1.0);
        p2.setY(null);
        assertThrows(IllegalArgumentException.class, () ->  p1.compare(p2));
    }

    @Test
    void toString_P1() {
        p1.setX(1.0);
        p1.setY(1.0);
        String actual = p1.toString();
        String expected = "x=1.0 y=1.0";
        assertEquals(expected, actual);
    }

    @Test
    void toString_P2() {
        p2.setX(-1.0);
        p2.setY(1.0);
        String actual = p2.toString();
        String expected = "x=-1.0 y=1.0";
        assertEquals(expected, actual);
    }

}
