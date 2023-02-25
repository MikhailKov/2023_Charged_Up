package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class piston extends SubsystemBase {
    private Solenoid sole;

    public piston(Solenoid p) {
        sole = p;
    }

    public void toggleSolenoid() {
        sole.toggle();
        System.out.println("toggleSolenoid");
    }
}