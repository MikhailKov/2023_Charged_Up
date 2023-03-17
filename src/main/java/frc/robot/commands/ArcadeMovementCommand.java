package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArcadeMovement;
import frc.robot.Robot;

public class ArcadeMovementCommand extends CommandBase {
    private ArcadeMovement move;
    public ArcadeMovementCommand (ArcadeMovement move) {
        this.move = move;
        addRequirements(this.move);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        move.drive();
       // System.out.println("hi");
    }

    @Override 
    public void end(boolean interrupted) {
        Robot.Drive.arcadeDrive(0, 0);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public boolean runsWhenDisabled() {return true;}
}