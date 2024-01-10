package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;
//Follows Preload point or just by itself, drives forward then backward and docks
public class AutonomousTwo extends CommandBase {
    

    Timer time;
    public ADXRS450_Gyro gyro;
    boolean leftCommunity;

    public AutonomousTwo() {
        addRequirements(Robot.Drive);
        gyro = RobotMap.gyro;
    }

    @Override
    public void initialize()
    {
        time = new Timer();
        gyro.calibrate();
        gyro.reset();
        Robot.Drive.arcadeDrive(0, 1);
    }

    @Override
    public void execute()
    {
        //prob want to fix encoder distance -> set encoder disgtance in initialize
        //so the robot DOES NOT jiust immediately end after finishing, it's important that it ends while the bumper
        //is off the charging station BUT is still at an angle so we can get points

        //Negative angle -> positive y

        int angle = (int) gyro.getAngle();
        System.out.println(angle);
        
        if(!leftCommunity && (angle <= -5 || angle >= 5)) {
            leftCommunity = true;
        }
        else if(!leftCommunity) 
            Robot.Drive.arcadeDrive(0, -1);
        else if(leftCommunity) {
            Robot.Drive.arcadeDrive(0, -1 * (angle/(Math.abs(angle))) * .5);
        }
    }

    @Override
    public boolean isFinished() {
       return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.Drive.arcadeDrive(0, 0);
    }
}
