package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Robot;
import frc.robot.commands.GripCommand;
import frc.robot.commands.RobotArmCommand;
public class AutonomousOne extends CommandBase {
    Timer time;
    double timeElapse;
    public AutonomousOne() {
        addRequirements(Robot.grip, Robot.Drive, Robot.arm);
    }

    @Override
    public void initialize() {
        time = Robot.time;
        Robot.Drive.arcadeDrive(.5, 0);
        /*
        while(gyro.angle() < 180){
        }
        */
        Robot.Drive.arcadeDrive(0,0);
        CommandScheduler.getInstance().schedule(new RobotArmCommand(Robot.arm, true));
        timeElapse = time.get();
    }

    @Override
    public void execute() {
        if(time.get()-timeElapse < 3)
        {
            CommandScheduler.getInstance().schedule(new GripCommand(Robot.grip, false));
        }
    }

    @Override
    public boolean isFinished() {
        if(time.get()-timeElapse >= 3) {
            return true;
        }
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.Drive.arcadeDrive(-.5, 0);
        /*
        while(gyro.angle() < 360){
        }
        */
        Robot.Drive.arcadeDrive(0,0);
    }

}
