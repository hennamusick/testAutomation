package exercises;

public class Enum {

    public enum daysOfWeek {
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday
    }

    public static void main(String[] args) {
        daysOfWeek today = daysOfWeek.Monday;
        daysOfWeek tomorrow = daysOfWeek.Tuesday;
        System.out.println("Today is " + today);
        System.out.println("Tomorrow is " + tomorrow);
    }
}
