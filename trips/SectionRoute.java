package spring_epam18;

public class SectionRoute extends AbstractRoute{

    private int distanceAC;
    private int distanceCB;

    public SectionRoute(Trip trip, double speed, Time pauseTime, int distanceAC, int distanceCB){
        super(trip, speed, pauseTime);
        this.distanceAC = distanceAC;
        this.distanceCB = distanceCB;
    }

    @Override
    protected Time getTripTime (){
        return super.setTrip().getTime(distanceAC, distanceCB);
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + "AC: " + distanceAC + " km" + ";" + " CB: " + distanceCB + " km" + " = " + getTripTime();
    }

    public int compareTo(AbstractRoute route) {
        return route.getTripTime().compareTo(getTripTime());
    }

}
