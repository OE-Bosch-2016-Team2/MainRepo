package egineandgearbox;

/**
 *
 * @author Laci
 */
public interface IEngine {

    void operateEngine(int gearState, boolean gasPedal);

    double getRpm();

    double getTorque();
}