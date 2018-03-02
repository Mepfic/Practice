package spring_epam18;

public class ArcRoute extends AbstractRoute{

    private double arcRadius;
    private double angle;

    public ArcRoute(Trip trip, double speed, Time pauseTime, double arcRadius, double angle){
        super(trip, speed, pauseTime);
        this.arcRadius = arcRadius;
        this.angle = angle;
    }

    @Override
    protected Time getTripTime (){
        return super.setTrip().getTime(arcRadius, angle);
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + "radius: " + arcRadius + " km" + "; " + "angle: " + angle + " km" + " = " + getTripTime();
    }

    public int compareTo(AbstractRoute route) {
        return route.getTripTime().compareTo(getTripTime());
    }

}
