package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
public class AutonomousOne extends CommandBase {
    //after preload
    //possible turn
    //drive forward
    //extend arm
    //open gripper
    //drive forward?
    //close gripper
    //turn around
    //go back
    //line up with the thing
    //go forward
    //extend arm
    //go forward????
    //open gripper
    //go back to neutral position idk
    
    static Timer time;

    public AutonomousOne() {
        addRequirements(Robot.Drive);
    }

    @Override
    public void initialize() {
        time = new Timer();
    }

    @Override
    public void execute() {
        Robot.Drive.arcadeDrive(0, -.5);
    }

    @Override
    public boolean isFinished() {
        if(time.get() >= 15 || Robot.Drive.encoderL.getDistance() >= 108.125) return true;
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.Drive.arcadeDrive(0, 0);
    }

}
