package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
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
    public void initialize() {
        if(open) grip.open();
        else grip.close();
    }

    @Override
    public void execute() {
        
    }

    @Override
    public boolean isFinished() {
        return (open && !RobotMap.XController.getRightBumper()) || (!open && !RobotMap.XController.getLeftBumper());
    }

    @Override
    public void end(boolean interrupted) {
        grip.stop();
    }
}
