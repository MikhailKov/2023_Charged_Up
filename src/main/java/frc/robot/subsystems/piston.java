package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class piston extends SubsystemBase {
    private DoubleSolenoid sole;

    public piston(DoubleSolenoid p) {
        sole = p;
        sole.set(Value.kReverse);
    }

    public void toggleSolenoid() {
        sole.toggle();
    }
}