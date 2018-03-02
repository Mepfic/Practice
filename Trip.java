package spring_epam18;

public final class Trip {
    private String name;
    private double speed;
    private boolean pauseInclude;
    private Time pauseTime;
    private Time tripTime;


    public Trip (){
        this ("", false);
    }

    public Trip (String name, boolean pauseInclude){
        this.name = name;
        this.pauseInclude = pauseInclude;
    }

    public void setTrip(double speed, Time pauseTime) {
        this.speed = speed;
        this.pauseTime = pauseTime;
    }

    public Time getTime(int distance){
        Time timeWithoutPause = new Time(distance / speed);
        if (pauseInclude) this.tripTime =  timeWithoutPause.add(pauseTime);
        else this.tripTime = timeWithoutPause;
        return tripTime;
    }

    public Time getTime(double arcRadius, double angle) {
        Time timeWithoutPause = new Time (Math.PI*arcRadius*angle / 180 / speed);
        if (pauseInclude) this.tripTime = timeWithoutPause.add(pauseTime);
        else this.tripTime = timeWithoutPause;
        return tripTime;
    }

    public Time getTime(int distanceAC, int distanceCB){
        Time timeWithoutPause = new Time ((distanceAC + distanceCB) / speed);
        if (pauseInclude) this.tripTime = timeWithoutPause.add(pauseTime);
        else this.tripTime = timeWithoutPause;
        return tripTime;
    }

    @Override
    public String toString() {
        return name + ":" + tripTime;
    }
}
