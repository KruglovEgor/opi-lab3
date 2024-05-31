import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static util.AreaChecker.checkHit;

public class AreaCheckerTest {

    @Test
    public void testIsInAreaForRectangle() {
        // Inside the rectangle
        assertTrue(checkHit(-4, 1, 10));
        assertTrue(checkHit(-5, 10, 10));
        assertTrue(checkHit(-2, 5, 10));

        // Outside the rectangle
        assertFalse(checkHit(-6, 1, 10));
        assertFalse(checkHit(-1, 11, 10));
    }

    @Test
    public void testIsInAreaForSemiCircle() {
        // Inside the semi-circle
        assertTrue(checkHit(10, 0, 10));
        assertTrue(checkHit(0, 10, 10));
        assertTrue(checkHit(5, 5, 10));
        assertTrue(checkHit(0, 0, 10));

        // Outside the semi-circle
        assertFalse(checkHit(10, 10, 10));
        assertFalse(checkHit(0, 11, 10));
        assertFalse(checkHit(11, 0, 10));
    }

    @Test
    public void testIsInAreaForTriangle() {
        // Inside the triangle
        assertTrue(checkHit(-5, 0, 10));
        assertTrue(checkHit(0, -10, 10));
        assertTrue(checkHit(-1, -1, 10));
        assertTrue(checkHit(-2.5, -2.5, 10));

        // Outside the triangle
        assertFalse(checkHit(-5, -0.1, 10));
        assertFalse(checkHit(-6, -2, 10));
        assertFalse(checkHit(0, -11, 10));
    }

    @Test
    public void testIsInAreaForEmptySector() {
        for (int i = 1; i < 10; ++i) {
            for (int j = -1; j > -10; --j) {
                assertFalse(checkHit(i, j, 10));
            }
        }
    }
}
