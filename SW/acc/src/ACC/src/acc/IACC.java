/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acc;

/**
 *
 * @author Laci
 */
public interface IACC {
    int getPedal();
    void PedalState(int wheelStateInDegrees, int currentSpeed, int targetSpeed, int nearestObstacleDistance);
}
