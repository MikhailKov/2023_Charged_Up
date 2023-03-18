package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class RobotArm extends SubsystemBase{
    public boolean pistonState = false;
    public DoubleSolenoid armPiston;

    public RobotArm(DoubleSolenoid piston) {
        armPiston = piston;
    }

    public void up() {
        if (!pistonState){
            armPiston.set(Value.kForward);
            pistonState = !pistonState;
        }
    }

    public void down() {
        if (pistonState){
            armPiston.set(Value.kReverse);
            pistonState = !pistonState;
        }
    }

    public void stop() {
        if (!pistonState){
            armPiston.set(Value.kForward);
            pistonState = !pistonState;
        }
    }
}
