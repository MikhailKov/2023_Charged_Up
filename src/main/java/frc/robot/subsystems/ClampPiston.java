package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClampPiston extends SubsystemBase {
	private Solenoid piston = RobotMap.piston;

    public void toggleSolenoid() {
        piston.toggle();
    }

    public boolean getToggled() {
        return piston.get();
    }
}
