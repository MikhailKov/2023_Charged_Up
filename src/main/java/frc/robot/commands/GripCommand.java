package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Grip;

public class GripCommand extends CommandBase{
    Grip grip;
    boolean open;

    public GripCommand(Grip grip, boolean open) {
        this.grip = grip;
        this.open = open;

        addRequirements(this.grip);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        if(open) grip.open();
        else grip.close();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        grip.stop();
    }
}