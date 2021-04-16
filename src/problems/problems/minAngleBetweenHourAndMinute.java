package problems.problems;

public class minAngleBetweenHourAndMinute {

    public static void main(String[] args) {
        double v = angleClock(9, 15);
    }

    // break down degree per hour, degree per minute
    public static double angleClock(int hour, int minutes) {
        // 60 minutes in an hour
        // 360/60 = 6 degree per minute
        double minuteDegree = minutes * 6;

        // calculate time off hour (hour + minute) ex. how many hours is in 15 minutes? (15/60)
        double timeInHour = hour + ((double) minutes / 60);

        // 360/12 = 30 degree per hour
        double hourDegree = timeInHour * 30;

        // find angle difference
        double clockwise = Math.abs(hourDegree - minuteDegree);

        // return lowest angle (clockwise vs anti clockwise)
        return Math.min(clockwise, 360d-clockwise);
    }
}
