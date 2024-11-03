package exercises;

public class DayWithNumber {

    private static final String[] DAYS = {"Invalid Day", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    public static void main(String[] args) {
        int day = 3;
        System.out.println(day + ": " + dayByName(day) );
    }

    public static String dayByName(int day){
        return (day >= 1 && day <=7) ? DAYS[day] : DAYS[0];
    }

}
