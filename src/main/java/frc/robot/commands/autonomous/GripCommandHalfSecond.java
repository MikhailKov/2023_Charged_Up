package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Grip;

public class GripCommandHalfSecond extends CommandBase{
    Grip grip;
    boolean open;
    Timer time;

    public GripCommandHalfSecond(Grip grip, boolean open) {
        this.grip = grip;
        this.open = open;

        addRequirements(this.grip);
    }

    @Override
    public void initialize() {
        time = new Timer();
        if(open) grip.open();
        else grip.close();
    }

    @Override
    public void execute() {
        
    }

    @Override
    public boolean isFinished() {
        return time.hasElapsed(.5);
    }

    @Override
    public void end(boolean interrupted) {
        grip.stop();
    }
}
