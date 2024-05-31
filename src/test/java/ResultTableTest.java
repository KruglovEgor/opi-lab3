import beans.Point;
import beans.ResultTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResultTableTest {
    private ResultTable resultTable;
    private final List<Point> POINTS_TO_ADD = Collections.unmodifiableList(
        new ArrayList<Point>() {{
            for (int i = -5; i < 5; i++) {
                for (int j = -5; j < 5; j++) {
                    Point point = new Point(i, j, 5, false, 0, 0);
                }
            }
        }}
    );

    @BeforeEach
    public void setUp() {
        resultTable = new ResultTable();
        resultTable.init();
    }

    @Test
    public void shouldBeEmptyAfterClean() {
        resultTable.clear();
        assertTrue(resultTable.getResults().isEmpty());
    }

    @Test
    public void shouldAddCorrectNumberOfPoints() {
        int initialCount = resultTable.getResults().size();
        int countToAdd = POINTS_TO_ADD.size();

        POINTS_TO_ADD.forEach(point -> {
            point.setTable(resultTable);
            point.check();
            resultTable.addPoint(point);
        });

        int finalCount = resultTable.getResults().size();

        assertEquals(initialCount + countToAdd, finalCount);
    }
}
