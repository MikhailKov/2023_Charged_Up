package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RobotArm extends SubsystemBase{
    public Victor m1, m2;
    public double speed;

    public RobotArm(int channelOne, int channelTwo, double speed) {
        m1 = new Victor(channelOne);
        m2 = new Victor(channelTwo);
        this.speed = speed;
    }

    public void up() {
        m1.set(speed);
        m2.set(-1 * speed);
    }

    public void down() {
        m1.set(-1 * speed);
        m2.set(speed);
    }

    public void stop() {
        m1.set(0);
        m2.set(0);
    }
}
