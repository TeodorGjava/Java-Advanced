package OOP.workingWithAbstraction.Lab.pointInRect;

public class Point {
int x;
int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean greaterOrEqual(Point other){
        return x>= other.x&&y>= other.y;
    }
    public boolean lessOrEqual(Point c){
        return x<=c.x&&y<=c.y;
    }
}
