package util;

public class AreaChecker {
    public static boolean checkHit(double x, double y, double r){
        return  ((x >= - r / 2) && (x <= 0) && (y >= 0) && (y <= r))
                || ((x <= 0) && (x >= -r / 2) && (y <= 0) && (y >= -r - 2 * x))
                || ((x >= 0) && (y >= 0) && (x * x + y * y <= r * r ));
    }
}
