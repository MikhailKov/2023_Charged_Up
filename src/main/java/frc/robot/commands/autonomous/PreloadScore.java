package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.commands.*;


public class PreloadScore extends SequentialCommandGroup{

    public PreloadScore() {
        addRequirements(Robot.Drive, Robot.Cameras, Robot.grip, Robot.arm);
        addCommands(
            new RobotArmAutoCommand(Robot.arm, false).withTimeout(2.5),
            new DriveTwoSeconds(true).withTimeout(2.5),
            new ClampPistonCommand(Robot.m_piston).withTimeout(1.5),
            new GripCommandHalfSecond(Robot.grip, true).withTimeout(1.5),
            new ParallelCommandGroup(
                new GripCommandHalfSecond(Robot.grip, false).withTimeout(1.5),
                new ClampPistonCommand(Robot.m_piston).withTimeout(1.5),
                new DriveTwoSeconds(false).withTimeout(2.5)
            ),
            new RobotArmAutoCommand(Robot.arm, true).withTimeout(2)
        );
    }

}
