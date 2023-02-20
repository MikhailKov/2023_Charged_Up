package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Grip extends SubsystemBase{
    private Victor gripMotor;
    private double speed;

    public Grip(int channel, double speed) {
        gripMotor = new Victor(channel);
        this.speed = speed;
    }

    public void open() {
        gripMotor.set(speed);
    }

    public void close() {
        gripMotor.set(-speed);
    }

    public void stop() {
        gripMotor.set(0);
    }
}
