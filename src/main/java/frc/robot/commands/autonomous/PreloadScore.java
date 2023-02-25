package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.RobotMap;
import frc.robot.commands.ClampPistonCommand;
import frc.robot.commands.GripCommand;
import frc.robot.commands.RobotArmCommand;


public class PreloadScore extends CommandBase{
    //code for the ideal autonomous score, scores the preloaded point
    //start robot facing backward
    //line up/check camera
    //extend arm
    //drive forward
    //release gripper
    //unextend arm/go backwards
    //turn around
    //go to autonomousone or autonomoustwo

    Timer time;
    public Encoder encoderL, encoderR;
    boolean scoredPoint = false;
    boolean goneForward = false;
    boolean linedUp = false;
    boolean armUp = false;


    public PreloadScore() {
        addRequirements(Robot.Drive, Robot.Cameras, Robot.grip, Robot.arm);
        encoderL = Robot.Drive.encoderL;
        encoderR = Robot.Drive.encoderR;
    }

    @Override
    public void initialize() {
        time = new Timer();
    }

    @Override
    public void execute() {
        //make sure to fix distance in preloadscore
        double distance = 10;
        //line up/check camera
        
        //extend arm
        //this assumes arm starts at lowest position
        if(linedUp && !armUp) {
            CommandScheduler.getInstance().schedule(new RobotArmCommand(Robot.arm, true));
            CommandScheduler.getInstance().schedule(new RobotArmCommand(Robot.arm, true));
            CommandScheduler.getInstance().schedule(new RobotArmCommand(Robot.arm, true));
            armUp = true;
        }
        //drive forward
        if (encoderL.getDistance() <= distance && armUp) {
            Robot.Drive.arcadeDrive(.5, .5);
        }
        // extend piston, release gripper and lower arm
        if(encoderL.getDistance() >= distance) {
            CommandScheduler.getInstance().schedule(new ClampPistonCommand(Robot.m_piston));
            CommandScheduler.getInstance().schedule(new GripCommand(Robot.grip, true));
            CommandScheduler.getInstance().schedule(new GripCommand(Robot.grip, false));
            CommandScheduler.getInstance().schedule(new RobotArmCommand(Robot.arm, false));
            CommandScheduler.getInstance().schedule(new RobotArmCommand(Robot.arm, false));
            CommandScheduler.getInstance().schedule(new RobotArmCommand(Robot.arm, false));
            scoredPoint = true;
        }
    }

    @Override
    public boolean isFinished() {
        return scoredPoint || time.hasElapsed(15);
        //should it end attempt at 15 sec or earlier?
    }

    @Override
    public void end(boolean interrupted) {
        //should stop moving, if gripper still holds the thing, it will keep arm/gripper extended
        //if it is no longer holding the thing, it will close gripper/put arm up
        //the code assmes the arm is at the highest position, and will lower the arm three segments if the point has been scored
        Robot.Drive.arcadeDrive(0, 0);
        if (scoredPoint) {
            //turn around
        }
    }

}
