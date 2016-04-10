package acc;

/**
 *
 * @author Laci
 */
public class ACC implements IACC {

    private int minFollowingTime; //in secs
    private final int maxSpeed = 200; //in km/h

    private int pedal;

    @Override
    public int getPedal() {
        return pedal;
    }

    public ACC() {
        pedal = 0;
        minFollowingTime = 2;
    }

    @Override
    public void PedalState(int wheelStateInDegrees, int currentSpeed, int targetSpeed, int nearestObstacleDistance) {
        if (targetSpeed != 0) {//ACC is on
            double safeDistance = currentSpeed / 3.6 * minFollowingTime;//km/h to m/s * s = m
            if (targetSpeed < currentSpeed) {
                pedal = -1;//breaking
            } else if (currentSpeed < maxSpeed - Math.abs(wheelStateInDegrees * 4)) {//Should we accelerate?
                if (safeDistance > nearestObstacleDistance) {//break
                    pedal = -1;
                } else if (targetSpeed == currentSpeed) {//fine
                    pedal = 0;
                } else {//throttle
                    pedal = 1;
                }
            } else if (currentSpeed == maxSpeed - Math.abs(wheelStateInDegrees * 4)) {
                pedal = 0;//fine
            } else {
                pedal = -1;//break
            }
        } else {
            //do nothing
            pedal = 0;
            System.out.println("0");
        }
    }
}
