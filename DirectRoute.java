package spring_epam18;

public class DirectRoute extends AbstractRoute{

    private int distance;

    public DirectRoute(Trip trip, double speed, Time pauseTime, int distance){
        super(trip, speed, pauseTime);
        this.distance = distance;
    }

    @Override
    protected Time getTripTime (){
        return super.setTrip().getTime(distance);
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + distance + " km" + " = " + getTripTime();
    }

    public int compareTo(AbstractRoute route) {
        return route.getTripTime().compareTo(getTripTime());
    }
}
