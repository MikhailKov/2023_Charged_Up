import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Victor;

public class RobotArm extends SubsystemBase {
    private Victor motorOne = new Victor(RobotMap.ROBOT_ARM_MOTOR_ONE_CHANNEL);
    private Victor motorTwo = new Victor(RobotMap.ROBOT_ARM_MOTOR_TWO_CHANNEL);

    private int speed = .5;

    public void on(boolean goUp) {
        if(goUp) {
            motorOne.set(speed);
            motorTwo.set(-speed);
        }
        else {
            motorOne.set(-speed);
            motorTwo.set(speed);
        }
    }

    public void off() {
        motorOne.set(0);
        motorTwo.set(0);
    }
}