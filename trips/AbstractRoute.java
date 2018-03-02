package spring_epam18;

public abstract class AbstractRoute implements Comparable<AbstractRoute>{
    private final Trip trip;
    private double speed;
    private Time pauseTime;
    private Time tripTime;

    public AbstractRoute(Trip trip, double speed, Time pauseTime){
        this.trip = trip;
        this.speed = speed;
        this.pauseTime = pauseTime;
    }

    protected String fieldsToString() {
        return speed + " km/h; ";
    }

    protected Trip setTrip() {
        trip.setTrip(speed, pauseTime);
        return trip;
    }

    protected Time getTripTime(){
        return tripTime;
    }

    @Override
    public String toString() {
        return fieldsToString();
    }
}
