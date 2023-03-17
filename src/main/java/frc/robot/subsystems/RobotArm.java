package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class RobotArm extends SubsystemBase{
    public Victor armMotor;
    public double speed;
    public boolean pistonState = false;
    public DoubleSolenoid armPiston;

    public RobotArm(int channel, double speed) {
        armMotor = new Victor(channel);
        this.speed = speed;
        armPiston = RobotMap.armPiston;
    }

    public void up() {
        armMotor.set(0);
        //armMotor.set(speed);
        if (!pistonState){
            armPiston.set(Value.kForward);
            pistonState = !pistonState;
        }
    }

    public void down() {
        armMotor.set(0);
        //armMotor.set(-speed);
        if (pistonState){
            armPiston.set(Value.kReverse);
            pistonState = !pistonState;
        }
    }

    public void stop() {
        armMotor.stopMotor();
        if (!pistonState){
            armPiston.set(Value.kForward);
            pistonState = !pistonState;
        }
    }
}
