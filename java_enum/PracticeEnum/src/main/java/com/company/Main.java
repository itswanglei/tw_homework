package main.java.com.company;

public class Main {

    public static void main(String[] args) {
        Week sunday = Week.valueOf("SUNDAY");
        System.out.println(sunday);

        for (Week week : Week.values()) {
            System.out.println(week.name() + ": " + week.getDay());
        }

        Week anotherSunday = Week.valueOf("SUNDAY");
        System.out.println(anotherSunday.equals(sunday));

        System.out.println(getDaySituation(sunday));
    }

    public static String getDaySituation(Week day) {
        String situation;
        switch (day) {
            case SUNDAY:
            case SATURDAY:
                situation = "Weekends are best!";
                break;
            case FRIDAY:
                situation = "Friday is better!";
                break;
            case MONDAY:
                situation = "Monday is bad!";
                break;
            default:
                situation = "Midweek days are just so so.";
                break;
        }
        return situation;
    }
}
