package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutonomousOne extends CommandBase {
    
    Timer time = new Timer();
    int frameCount = 0;
    int moveDuration = 70;

    public AutonomousOne() {
        addRequirements(Robot.Drive);
    }

    public void initialize() {
        frameCount = 0;
    }

    public void execute() {
        System.out.println("edcndo");
        Robot.Drive.tankDrive(-.7, -.7);
        frameCount++;
    }

    public boolean isFinished() {
        if(time.get() >= 15 || Robot.Drive.encoderL.getDistance() >= 10) return true;
        return false;
    }

    public void end(boolean interrupted) {
        Robot.Drive.arcadeDrive(0, 0);
    }

}
