package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Timer;

public class ArcadeMovement extends SubsystemBase{

    // set to 0 if not constant thrust - you want it to go faster when u push joystick further
    // otherwise, it will just use the constant as the thrust for everything.

    // {thrust const, thrustX, thrustY}
    public static double[] thrustConstant = {0, 0, 0};
    public XboxController controller;
    Timer timer = new Timer();
    double scalar;

    public ArcadeMovement() {
        controller = RobotMap.XController;
        timer.start();
    }


    public void periodic() {
        if(Math.abs( ( (int) (controller.getLeftX() * 20) )/20.0 ) == 0) {
            /*if(Math.abs( ( (int) (controller.getLeftY() * 20) )/20.0 ) == 0)
            {
                timer.reset();
                return;
            }*/
        }
        if (thrustConstant[0] > 0) {
            thrustConstant[1] = thrustConstant[0];
            thrustConstant[2] = thrustConstant[0];
        } else if (thrustConstant[0] == 0) {
            //scalar = Math.min(10.0, timer.get()) / 10.0;
            thrustConstant[1] = controller.getLeftX();// * scalar;
            thrustConstant[2] = controller.getLeftY();// * scalar; 
            //System.out.println(timer.get() + " " + scalar);
        }

        if(controller.getLeftY() >= 0) {
            if(controller.getLeftX() >= 0) {
                Robot.Drive.arcadeDrive(thrustConstant[1], (thrustConstant[0] > 0 ? -1 : 1) * thrustConstant[2]);

            } else {
                Robot.Drive.arcadeDrive((thrustConstant[0] > 0 ? -1 : 1) * thrustConstant[1], (thrustConstant[0] > 0 ? -1 : 1) * thrustConstant[2]);
            }
        } else {
            if(controller.getLeftX() >= 0) {
                Robot.Drive.arcadeDrive(thrustConstant[1], thrustConstant[2]);
            } else {
                Robot.Drive.arcadeDrive((thrustConstant[0] > 0 ? -1 : 1) * thrustConstant[1], thrustConstant[2]);
            }
        }
    }  
}
