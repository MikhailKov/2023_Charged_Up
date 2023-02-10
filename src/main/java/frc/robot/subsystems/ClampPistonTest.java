package frc.robot.subsystems;

import java.util.Set;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class ClampPistonTest extends SubsystemBase {
	// private Solenoid piston = RobotMap.piston;

    public void toggleSolenoid() {
        System.out.println("toggleSolenoidTest");
    }

    // public boolean getToggled() {
    //     return piston.get();
    // }
}
