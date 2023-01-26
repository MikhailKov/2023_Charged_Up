package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ArcadeMovement extends CommandBase implements Runnable{

    // set to 0 if not constant thrust - you want it to go faster when u push joystick further
    // otherwise, it will just use the constant as the thrust for everything.

    // {thrust const, thrustX, thrustY}
    public static double[] thrustConstant = {0, 0, 0};
    public XboxController controller;

    public ArcadeMovement() {
        controller = RobotMap.XController;
        System.out.println("arcade movt");
        execute();  
    }

    @Override
    public void initialize() {
        // unused
    }
    
    @Override
    public void run() {
        
        if (thrustConstant[0] > 0) {
            thrustConstant[1] = thrustConstant[0];
            thrustConstant[2] = thrustConstant[0];
        } else if (thrustConstant[0] == 0) {
            thrustConstant[1] = RobotMap.analogLeft.getX();
            thrustConstant[2] = RobotMap.analogLeft.getY(); 
        }

        if(controller.getLeftY() >= 0) {
            if(RobotMap.analogLeft.getX() >= 0) {
                Robot.Drive.arcadeDrive(thrustConstant[1], (thrustConstant[0] > 0 ? -1 : 1) * thrustConstant[2]);

            } else {
                Robot.Drive.arcadeDrive((thrustConstant[0] > 0 ? -1 : 1) * thrustConstant[1], (thrustConstant[0] > 0 ? -1 : 1) * thrustConstant[2]);
            }
        } else {
            if(RobotMap.analogLeft.getX() >= 0) {
                Robot.Drive.arcadeDrive(thrustConstant[1], thrustConstant[2]);
            } else {
                Robot.Drive.arcadeDrive((thrustConstant[0] > 0 ? -1 : 1) * thrustConstant[1], thrustConstant[2]);
            }
        }
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }

    @Override
    public void end(boolean interrupted) {
        Robot.Drive.arcadeDrive(0, 0);
    }

    
}
