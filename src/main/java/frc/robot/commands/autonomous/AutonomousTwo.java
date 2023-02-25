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
    public Encoder encoderL, encoderR;
    public ADXRS450_Gyro gyro;
    boolean leftCommunity;

    public AutonomousTwo() {
        addRequirements(Robot.Drive);
        encoderL = Robot.Drive.encoderL;
        encoderR = Robot.Drive.encoderR;
        gyro = RobotMap.gyro;
    }

    @Override
    public void initialize()
    {
        time = new Timer();
        gyro.reset();
        gyro.calibrate();
    }

    @Override
    public void execute()
    {
        //prob want to fix encoder distance -> set encoder disgtance in initialize
        //so the robot DOES NOT jiust immediately end after finishing, it's important that it ends while the bumper
        //is off the charging station BUT is still at an angle so we can get points

        double angle = gyro.getAngle();
        leftCommunity = true;
        if (encoderL.getDistance() >= 10)
            leftCommunity = true;
        else if (encoderL.getDistance() < 10 && !leftCommunity)
            Robot.Drive.arcadeDrive(0, -.5);
        else if (leftCommunity && angle <= -1)
            Robot.Drive.arcadeDrive(0, .5);
        else if (leftCommunity && angle >= 1)
            Robot.Drive.arcadeDrive (0, -.5);
    }

    @Override
    public boolean isFinished() {
       if(time.hasElapsed(15)) {
        return false;
       } else {
        return false;
       }
    }

    @Override
    public void end(boolean interrupted) {
        Robot.Drive.arcadeDrive(0, 0);
    }
}
