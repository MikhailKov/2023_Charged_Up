package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class ClampPiston extends SubsystemBase {
	private Solenoid piston = RobotMap.piston;

    public void toggleSolenoid() {
        piston.toggle();
        System.out.println(getToggled());
    }

    public boolean getToggled() {
        return piston.get();
    }
}
