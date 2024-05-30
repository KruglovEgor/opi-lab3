package beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

import static util.AreaChecker.checkHit;

@ManagedBean(name = "point")
@SessionScoped
@NoArgsConstructor
public class Point implements Serializable {
    @Getter
    @Setter
    private double x;
    @Getter
    @Setter
    private double y;
    @Getter
    @Setter
    private double r;
    @Getter
    @Setter
    private boolean hit;
    @Getter
    @Setter
    private long attemptTime;
    @Getter
    @Setter
    private double executionTime;
    @ManagedProperty(value = "#{table}")
    @Getter
    @Setter
    private transient ResultTable table;

    public Point(double x, double y, double r, boolean hit, long attemptTime, double executionTime) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
        this.attemptTime = attemptTime;
        this.executionTime = executionTime;
    }

    public void check() {
        long start = System.nanoTime();
        long attemptTime = System.currentTimeMillis();
        boolean hit = checkHit(x, y, r);
        long executionTime = System.nanoTime() - start;
        table.addPoint(new Point(x, y, r, hit, attemptTime, executionTime));
    }
}
