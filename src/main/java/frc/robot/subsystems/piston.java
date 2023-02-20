package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class piston extends SubsystemBase {
    private Solenoid message;

    public piston(Solenoid p) {
        message = p;
    }

    public void toggleSolenoid() {
        message.toggle();
        System.out.println("toggleSolenoid");
    }
}