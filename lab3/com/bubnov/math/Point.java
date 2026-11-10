package com.bubnov.math;
import java.util.Objects;

public class Point {
    public int X;
    public int Y;

    public Point() {
    }

    public Point(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    @Override
    public String toString() {
        return String.format("{%s;%s}", X,Y);

    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Point other = (Point) obj;
        return this.X == other.X && this.Y == other.Y;
    }
    @Override
    public int hashCode() {
        // нужно определить для equals
        return Objects.hash(X, Y);
    }
}
