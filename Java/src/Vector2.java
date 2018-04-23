import java.lang.Math;

public class Vector2 {
    public double x;
    public double y;

    public Vector2() {
        x = 0;
        y = 0;
    }

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2 normalized() {
        return divide(distance(Vector2.zero));
    }

    public double distance(Vector2 other) {
        double dx = x - other.x;
        double dy = y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static Vector2 randomPosition(double x, double y) {
        return new Vector2(Math.random() * x, Math.random() * y);
    }

    public static Vector2 randomPosition(Vector2 min, Vector2 max) {
        Vector2 d = max.subtract(min);
        return new Vector2(Math.random() * d.x + min.x, Math.random() * d.y + min.y);
    }

    public static Vector2 randomDirection() {
        double r = Math.random() * 2 * Math.PI;
        return new Vector2(Math.cos(r), Math.sin((r)));
    }

    public static Vector2 randomDirection(double min, double max) {
        double r = Math.random() * (max - min) + min;
        return new Vector2(Math.cos(r), Math.sin((r)));
    }

    public Vector2 add(Vector2 other) {
        return new Vector2(x + other.x, y + other.y);
    }

    public Vector2 subtract(Vector2 other) {
        return new Vector2(x - other.x, y - other.y);
    }

    public Vector2 multiply(double k) {
        return new Vector2(x * k, y * k);
    }

    public Vector2 divide(double k) {
        return new Vector2(x / k, y / k);
    }

    public String toString() {
        return "(" + String.valueOf(x) + ", " + String.valueOf(y) + ")";
    }

    public boolean equals(Vector2 other) {
        return x == other.x && y == other.y;
    }

    public static final Vector2 zero = new Vector2();
    public static final Vector2 up = new Vector2(0, -1);
    public static final Vector2 down = new Vector2(0, 1);
    public static final Vector2 right = new Vector2(1, 0);
    public static final Vector2 left = new Vector2(-1, 0);
}
