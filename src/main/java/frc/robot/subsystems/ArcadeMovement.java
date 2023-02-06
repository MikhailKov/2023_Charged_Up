package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ArcadeMovement extends SubsystemBase{

    // set to 0 if not constant thrust - you want it to go faster when u push joystick further
    // otherwise, it will just use the constant as the thrust for everything.

    // {thrust const, thrustX, thrustY}
    public static double[] thrustConstant = {0, 0, 0};
    public XboxController controller;

    public ArcadeMovement() {
        controller = RobotMap.XController;
    }


    public void periodic() {
        int counter = 1000;
        if (thrustConstant[0] > 0) {
            thrustConstant[1] = thrustConstant[0];
            thrustConstant[2] = thrustConstant[0];
        } else if (thrustConstant[0] == 0) {
            thrustConstant[1] = controller.getLeftX() * (Math.min(4000, counter) / 4000);
            thrustConstant[2] = controller.getLeftY() * (Math.min(4000, counter) / 4000); 


        }

        if(controller.getLeftY() >= 0) {
            counter += 20;
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
