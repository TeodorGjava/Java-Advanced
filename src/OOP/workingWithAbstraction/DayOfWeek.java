package OOP.workingWithAbstraction;

public enum DayOfWeek {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private int dayNum;

    private DayOfWeek(int dayNum) {
        this.dayNum = dayNum;
    }
    public int getDayNum(){
        return this.dayNum;
    }
}

class demo {
    public static void main(String[] args) {
        DayOfWeek day1 = DayOfWeek.MONDAY;
        System.out.println(day1);
    }
}
