package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;
//Follows Preload point or just by itself, drives forward then backward and docks
public class DriveTwoSeconds extends CommandBase {
    Timer time;
    boolean forward;

    public DriveTwoSeconds(boolean forward) {
        addRequirements(Robot.Drive);
        this.forward = forward;
    }

    @Override
    public void initialize()
    {
        time = new Timer();
        

    }

    @Override
    public void execute()
    {
        if(forward)
            Robot.Drive.arcadeDrive(0, -.5);
        else 
            Robot.Drive.arcadeDrive(0, .5);
    }

    @Override
    public boolean isFinished() {
       return time.hasElapsed(2);
    }

    @Override
    public void end(boolean interrupted) {
        Robot.Drive.arcadeDrive(0, 0);
    }
}
