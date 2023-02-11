package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class piston extends SubsystemBase {
    private String message;

    public piston() {
        message = "piston!";
    }

    public String getMessage() {
        return message;
    }
}