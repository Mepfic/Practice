package spring_epam18;

import java.util.Arrays;

public class Run {
    public static void main(String[] args) {
        final Trip weekend = new Trip("weekend", true);
        final Trip everyday = new Trip("everyday", false);
        final Time shortPause = new Time (15);
        final Time halfHourPause = new Time (30);
        final Time longPause = new Time (45);
        AbstractRoute [] routes = {
                new DirectRoute(weekend, 50, shortPause, 1354),
                new DirectRoute(everyday, 70, shortPause, 32),
                new ArcRoute(everyday, 54, longPause, 18, 12),
                new SectionRoute(weekend, 62, shortPause, 68, 145),
                new SectionRoute(everyday, 88, longPause, 220, 197),
                new DirectRoute(weekend, 67, halfHourPause, 260),
                new ArcRoute(weekend, 78, longPause, 22, 115),
                new SectionRoute(weekend, 74, halfHourPause, 215, 120),
                new DirectRoute(everyday, 48, halfHourPause, 20),
                new SectionRoute(weekend, 65, longPause, 160, 190),
                new ArcRoute(weekend, 78, longPause, 222, 115),
                new ArcRoute(weekend, 77, longPause, 450, 160)
        };
        printRoutes(routes);
        AbstractRoute [] copy = routes.clo  ne();
        Arrays.sort(copy);
        printRoutes(copy);
        //System.out.println("The fastest trip is: " + copy[copy.length-1].getTripTime());
        fastestTrip(routes);
        ifTripFromTask(routes);

    }

    private static void printRoutes (AbstractRoute [] routes){
        for (AbstractRoute route : routes){
            System.out.println(route);
        }
        System.out.println();
    }

    private static void fastestTrip(AbstractRoute [] routes){
        Time time = routes[0].getTripTime();
        for (AbstractRoute route : routes){
            if (time.getMin() > route.getTripTime().getMin()){
                time = route.getTripTime();
            }
        }
        System.out.println("The fastest trip is: "+time);
        System.out.println();
    }

    private static void ifTripFromTask(AbstractRoute [] routes){
        int min = 25;
        int max = 30;
        int count = 0;
        for (AbstractRoute route : routes){
            if ((route.getTripTime().getMin() >= min)&&(route.getTripTime().getMin() <= max)){
                System.out.println(route.getTripTime());
                count++;
            }
        }
        if (count == 0){
            System.out.println("The array are NOT contained trips from 25 to 30 minutes.");
        } else {
            System.out.println("These trips from 25 to 30 minutes.");
        }
    }
}

