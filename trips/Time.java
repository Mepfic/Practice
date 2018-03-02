package spring_epam18;

public class Time implements Comparable <Time> {
    private int min;

    public Time(int min) {
        this.min = min;
    }

    public Time(double hours) {
        this.min = (int) Math.round(hours * 60);
    }

    public int getHours() {
        return min / 60;
    }

    public int getRestMin() {
        return min - getHours() * 60;
    }

    public int getMin() {
        return min;
    }

    public Time add(Time time) {
        return new Time(min + time.min);
    }

    @Override
    public int compareTo(Time other) {
        return min - other.min;
    }

    @Override
    public String toString() {
        if (getHours() == 0) {
            return getRestMin() + " m;";
        } else {
            return getHours() + " h," + getRestMin() + " m;";
        }
    }
}



