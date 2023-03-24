package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RobotArm extends SubsystemBase{
    public DoubleSolenoid armPiston;

    public RobotArm(DoubleSolenoid piston) {
        armPiston = piston;
    }

    public void down() {
        armPiston.set(Value.kForward);
    }

    public void up() {
        armPiston.set(Value.kReverse);
    }

    public void stop() {
        armPiston.set(Value.kOff);
        System.out.println("Stopping the Piston");
    }
}
